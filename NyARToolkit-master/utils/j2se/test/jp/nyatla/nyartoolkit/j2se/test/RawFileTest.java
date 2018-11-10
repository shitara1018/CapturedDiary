package jp.nyatla.nyartoolkit.j2se.test;
/* 
 * PROJECT: NyARToolkit
 * --------------------------------------------------------------------------------
 * This work is based on the original ARToolKit developed by
 *   Hirokazu Kato
 *   Mark Billinghurst
 *   HITLab, University of Washington, Seattle
 * http://www.hitl.washington.edu/artoolkit/
 *
 * The NyARToolkit is Java edition ARToolKit class library.
 * Copyright (C)2008-2009 Ryo Iizuka
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * For further information please contact.
 *	http://nyatla.jp/nyatoolkit/
 *	<airmail(at)ebony.plala.or.jp> or <nyatla(at)nyatla.jp>
 * 
 */


import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;


import jp.nyatla.nyartoolkit.core.marker.artk.NyARCode;
import jp.nyatla.nyartoolkit.core.param.NyARParam;
import jp.nyatla.nyartoolkit.core.raster.rgb.*;
import jp.nyatla.nyartoolkit.core.rasterdriver.perspectivecopy.INyARPerspectiveCopy;
import jp.nyatla.nyartoolkit.detector.*;
import jp.nyatla.nyartoolkit.j2se.NyARBufferedImageRaster;
import jp.nyatla.nyartoolkit.core.types.*;
import jp.nyatla.nyartoolkit.core.types.matrix.NyARDoubleMatrix44;

/**
 * このサンプルは、{@link NyARSingleDetectMarker}クラスの動作チェック＆ベンチマークプログラムです。
 * 静止画から1個のHiroマーカを認識して、その姿勢変換行列、パターン一致率を得る動作を確認できます。
 * 同時に、この処理を1000回実行して、処理時間を計測します。この数値は、NyARToolkitの基本性能の
 * 指標として使うことができます。
 * <p>必要なファイル - 
 * このプログラムの実行には、以下の外部ファイルが必要です。
 * <ul>
 * <li>camera_para.dat - ARToolKit付属のカメラパラメータファイル
 * <li>patt.hiro - ARToolKit付属のHiroマーカのパターンファイル
 * <li>320x240ABGR.raw　- Hiroマーカを撮影した、QVGAサイズのXBGR形式のサンプル画像
 * </ul>
 */
public class RawFileTest
{

	private final String data_file = "../../Data/320x240ABGR.png";
	
	private final String camera_file = "../../Data/camera_para.dat";

	/**
	 * コンストラクタです。
	 * ここでは処理を行いません。
	 */
	public RawFileTest()
	{
	}

	/**
	 * この関数は、テスト関数の本体です。
	 * カメラ設定ファイル、ARマーカのパターン読出しを読み込み、試験イメージに対してマーカ検出を実行します。
	 * マーカ検出を1000回繰り返して、経過した時間をms単位で表示します。
	 * @throws Exception
	 */
	public void Test_arDetectMarkerLite() throws Exception
	{
		// 試験イメージの読み出し(320x240 BGRAのデータ)
		INyARRgbRaster ra=new NyARBufferedImageRaster(ImageIO.read(new File(data_file)));		
/*		File f = new File(raw_file);
		FileInputStream fs = new FileInputStream(raw_file);
		byte[] buf = new byte[(int) f.length()];
		fs.read(buf);
		INyARRgbRaster ra = new NyARRgbRaster(320, 240,NyARBufferType.BYTE1D_B8G8R8X8_32,false);
		ra.wrapBuffer(buf);
*/		// AR用カメラパラメタファイルをロード
		NyARParam ap = NyARParam.loadFromARParamFile(new FileInputStream(camera_file),ra.getWidth(),ra.getHeight());

		//マーカパターンをBitmapから作る。
		NyARCode code = new NyARCode(16, 16);
//		code.loadARPatt(new FileInputStream(code_file));
		
		INyARRgbRaster im=new NyARBufferedImageRaster(ImageIO.read(new File("../../Data/hiro.png")));
		NyARIntSize s=im.getSize();
		INyARPerspectiveCopy pc=(INyARPerspectiveCopy)im.createInterface(INyARPerspectiveCopy.class);
		INyARRgbRaster tr=NyARRgbRaster.createInstance(16,16);
		pc.copyPatt(0,0,s.w,0,s.w,s.h,0,s.h,25, 25,4, tr);		
		code.setRaster(tr);


		// Blank_Raster ra=new Blank_Raster(320, 240);

		// １パターンのみを追跡するクラスを作成
		NyARSingleDetectMarker ar = NyARSingleDetectMarker.createInstance(
			ap, code, 80.0,NyARSingleDetectMarker.PF_NYARTOOLKIT);
		NyARDoubleMatrix44 result_mat = new NyARDoubleMatrix44();
		ar.setContinueMode(true);
		ar.detectMarkerLite(ra, 100);
		ar.getTransmat(result_mat);

		// マーカーを検出
		Date d2 = new Date();
		for (int i = 0; i < 1000; i++) {
			// 変換行列を取得
			ar.detectMarkerLite(ra, 100);
			ar.getTransmat(result_mat);
		}
		Date d = new Date();
		NyARDoublePoint3d ang=new NyARDoublePoint3d();
		result_mat.getZXYAngle(ang);
		System.out.println(d.getTime() - d2.getTime());
		System.out.print(		ar.getConfidence());
		
		
	}
    /**
     * プログラムのエントリーポイントです。
     * サンプルプログラム{@link RawFileTest}を実行します。
     * @param args
     * 引数はありません。
     */
	public static void main(String[] args)
	{

		try {
			RawFileTest t = new RawFileTest();
			// t.Test_arGetVersion();
			t.Test_arDetectMarkerLite();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
