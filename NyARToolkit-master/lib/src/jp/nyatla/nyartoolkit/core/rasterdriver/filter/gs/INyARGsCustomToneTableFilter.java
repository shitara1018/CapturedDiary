/* 
 * PROJECT: NyARToolkit(Extension)
 * --------------------------------------------------------------------------------
 *
 * The NyARToolkit is Java edition ARToolKit class library.
 * Copyright (C)2008-2012 Ryo Iizuka
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as publishe
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * For further information please contact.
 *	http://nyatla.jp/nyatoolkit/
 *	<airmail(at)ebony.plala.or.jp> or <nyatla(at)nyatla.jp>
 * 
 */
package jp.nyatla.nyartoolkit.core.rasterdriver.filter.gs;

import jp.nyatla.nyartoolkit.core.raster.gs.INyARGrayscaleRaster;
import jp.nyatla.nyartoolkit.core.types.NyARIntSize;

/**
 * このインタフェイスは、色調フィルタ関数を提供します。
 */
public interface INyARGsCustomToneTableFilter
{
	public void doFilter(int[] i_tone_table,INyARGrayscaleRaster i_output);	
}

class NyARGsCustomToneTableFilter_Any implements INyARGsCustomToneTableFilter
{
	private INyARGrayscaleRaster _raster;
	public NyARGsCustomToneTableFilter_Any(INyARGrayscaleRaster i_ref_raster)
	{
		this._raster=i_ref_raster;
	}
	public void doFilter(int[] i_tone_table,INyARGrayscaleRaster i_output)
	{
		INyARGrayscaleRaster outd= i_output;
		INyARGrayscaleRaster ind= this._raster;
		NyARIntSize s=this._raster.getSize();
		for(int y=s.h-1;y>=0;y--)
		{
			for(int x=s.w-1;x>=0;x--)
			{
				outd.setPixel(x, y,i_tone_table[ind.getPixel(x,y)]);
			}
		}
	}
}