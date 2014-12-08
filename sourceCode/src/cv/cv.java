package cv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class cv {

    static Random random = new Random();
	public static void main(String[] args) throws IOException {

		 String fileName = "./assets/lena.im";
		 int headerLength = 172;
		 int imageWidth = 512;
		 int imageHeight = 512;
		 
		 
		 Kernel octogonKernel = new Kernel(new int[][]{
				  { 0,1,1,1,0},
				  { 1,1,1,1,1},
				  { 1,1,1,1,1},
				  { 1,1,1,1,1},
				  { 0,1,1,1,0}
				},2,2);
		 
		 ArrayList<Integer> bytes = GetByteData(fileName);
		 
		 ArrayList<Integer> gaussianNoise10 = GaussianNoise(bytes,10,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> gaussianNoise10_Box33 = BoxFilter(gaussianNoise10,3,3,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> gaussianNoise10_Box55 = BoxFilter(gaussianNoise10,5,5,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> gaussianNoise10_Median33 = MedianFilter(gaussianNoise10,3,3,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> gaussianNoise10_Median55 = MedianFilter(gaussianNoise10,5,5,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> gaussianNoise10_Opening_Closing = Opening_Closing(gaussianNoise10,headerLength,imageWidth,imageHeight,octogonKernel);
		 ArrayList<Integer> gaussianNoise10_Closing_Opening = Closing_Opening(gaussianNoise10,headerLength,imageWidth,imageHeight,octogonKernel);
		 
		 ArrayList<Integer> gaussianNoise30 = GaussianNoise(bytes,30,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> gaussianNoise30_Box33 = BoxFilter(gaussianNoise30,3,3,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> gaussianNoise30_Box55 = BoxFilter(gaussianNoise30,5,5,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> gaussianNoise30_Median33 = MedianFilter(gaussianNoise30,3,3,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> gaussianNoise30_Median55 = MedianFilter(gaussianNoise30,5,5,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> gaussianNoise30_Opening_Closing = Opening_Closing(gaussianNoise30,headerLength,imageWidth,imageHeight,octogonKernel);
		 ArrayList<Integer> gaussianNoise30_Closing_Opening = Closing_Opening(gaussianNoise30,headerLength,imageWidth,imageHeight,octogonKernel);
		 
		 ArrayList<Integer> saltAndPepper01 = SaltAndPeper(bytes,0.1f,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> saltAndPepper01_Box33 = BoxFilter(saltAndPepper01,3,3,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> saltAndPepper01_Box55 = BoxFilter(saltAndPepper01,5,5,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> saltAndPepper01_Median33 = MedianFilter(saltAndPepper01,3,3,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> saltAndPepper01_Median55 = MedianFilter(saltAndPepper01,5,5,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> saltAndPepper01_Opening_Closing = Opening_Closing(saltAndPepper01,headerLength,imageWidth,imageHeight,octogonKernel);
		 ArrayList<Integer> saltAndPepper01_Closing_Opening = Closing_Opening(saltAndPepper01,headerLength,imageWidth,imageHeight,octogonKernel);
		 
		 ArrayList<Integer> saltAndPepper005 = SaltAndPeper(bytes,0.05f,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> saltAndPepper005_Box33 = BoxFilter(saltAndPepper005,3,3,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> saltAndPepper005_Box55 = BoxFilter(saltAndPepper005,5,5,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> saltAndPepper005_Median33 = MedianFilter(saltAndPepper005,3,3,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> saltAndPepper005_Median55 = MedianFilter(saltAndPepper005,5,5,headerLength,imageWidth,imageHeight);
		 ArrayList<Integer> saltAndPepper005_Opening_Closing = Opening_Closing(saltAndPepper005,headerLength,imageWidth,imageHeight,octogonKernel);
		 ArrayList<Integer> saltAndPepper005_Closing_Opening = Closing_Opening(saltAndPepper005,headerLength,imageWidth,imageHeight,octogonKernel);
		 
		 
		 WriteOut(gaussianNoise10,"./assets/gaussianNoise10.im");
		 WriteOut(gaussianNoise10_Box33,"./assets/gaussianNoise10_Box33.im");
		 System.out.println("gaussianNoise10_Box33:"+CalculateSNR(bytes,gaussianNoise10_Box33,headerLength));
		 WriteOut(gaussianNoise10_Box55,"./assets/gaussianNoise10_Box55.im");
		 System.out.println("gaussianNoise10_Box55:"+CalculateSNR(bytes,gaussianNoise10_Box55,headerLength));
		 WriteOut(gaussianNoise10_Median33,"./assets/gaussianNoise10_Median33.im");
		 System.out.println("gaussianNoise10_Median33:"+CalculateSNR(bytes,gaussianNoise10_Median33,headerLength));
		 WriteOut(gaussianNoise10_Median55,"./assets/gaussianNoise10_Median55.im");
		 System.out.println("gaussianNoise10_Median55:"+CalculateSNR(bytes,gaussianNoise10_Median55,headerLength));
		 WriteOut(gaussianNoise10_Opening_Closing,"./assets/gaussianNoise10_Opening_Closing.im");
		 System.out.println("gaussianNoise10_Opening_Closing:"+CalculateSNR(bytes,gaussianNoise10_Opening_Closing,headerLength));
		 WriteOut(gaussianNoise10_Closing_Opening,"./assets/gaussianNoise10_Closing_Opening.im");
		 System.out.println("gaussianNoise10_Closing_Opening:"+CalculateSNR(bytes,gaussianNoise10_Closing_Opening,headerLength));
		 
		 WriteOut(gaussianNoise30,"./assets/gaussianNoise30.im");
		 WriteOut(gaussianNoise30_Box33,"./assets/gaussianNoise30_Box33.im");
		 System.out.println("gaussianNoise30_Box33:"+CalculateSNR(bytes,gaussianNoise30_Box33,headerLength));
		 WriteOut(gaussianNoise30_Box55,"./assets/gaussianNoise30_Box55.im");
		 System.out.println("gaussianNoise30_Box55:"+CalculateSNR(bytes,gaussianNoise30_Box55,headerLength));
		 WriteOut(gaussianNoise30_Median33,"./assets/gaussianNoise30_Median33.im");
		 System.out.println("gaussianNoise30_Median33:"+CalculateSNR(bytes,gaussianNoise30_Median33,headerLength));
		 WriteOut(gaussianNoise30_Median55,"./assets/gaussianNoise30_Median55.im");
		 System.out.println("gaussianNoise30_Median55:"+CalculateSNR(bytes,gaussianNoise30_Median55,headerLength));
		 WriteOut(gaussianNoise30_Opening_Closing,"./assets/gaussianNoise30_Opening_Closing.im");
		 System.out.println("gaussianNoise30_Opening_Closing:"+CalculateSNR(bytes,gaussianNoise30_Opening_Closing,headerLength));
		 WriteOut(gaussianNoise30_Closing_Opening,"./assets/gaussianNoise30_Closing_Opening.im");
		 System.out.println("gaussianNoise30_Closing_Opening:"+CalculateSNR(bytes,gaussianNoise30_Closing_Opening,headerLength));
		 
		 WriteOut(saltAndPepper01,"./assets/saltAndPepper01.im");
		 WriteOut(saltAndPepper01_Box33,"./assets/saltAndPepper01_Box33.im");
		 System.out.println("saltAndPepper01_Box33:"+CalculateSNR(bytes,saltAndPepper01_Box33,headerLength));
		 WriteOut(saltAndPepper01_Box55,"./assets/saltAndPepper01_Box55.im");
		 System.out.println("saltAndPepper01_Box55:"+CalculateSNR(bytes,saltAndPepper01_Box55,headerLength));
		 WriteOut(saltAndPepper01_Median33,"./assets/saltAndPepper01_Median33.im");
		 System.out.println("saltAndPepper01_Median33:"+CalculateSNR(bytes,saltAndPepper01_Median33,headerLength));
		 WriteOut(saltAndPepper01_Median55,"./assets/saltAndPepper01_Median55.im");
		 System.out.println("saltAndPepper01_Median55:"+CalculateSNR(bytes,saltAndPepper01_Median55,headerLength));
		 WriteOut(saltAndPepper01_Opening_Closing,"./assets/saltAndPepper01_Opening_Closing.im");
		 System.out.println("saltAndPepper01_Opening_Closing:"+CalculateSNR(bytes,saltAndPepper01_Opening_Closing,headerLength));
		 WriteOut(saltAndPepper01_Closing_Opening,"./assets/saltAndPepper01_Closing_Opening.im");
		 System.out.println("saltAndPepper01_Closing_Opening:"+CalculateSNR(bytes,saltAndPepper01_Closing_Opening,headerLength));
		 
		 WriteOut(saltAndPepper005,"./assets/saltAndPepper005.im");
		 WriteOut(saltAndPepper005_Box33,"./assets/saltAndPepper005_Box33.im");
		 System.out.println("saltAndPepper005_Box33:"+CalculateSNR(bytes,saltAndPepper005_Box33,headerLength));
		 WriteOut(saltAndPepper005_Box55,"./assets/saltAndPepper005_Box55.im");
		 System.out.println("saltAndPepper005_Box55:"+CalculateSNR(bytes,saltAndPepper005_Box55,headerLength));
		 WriteOut(saltAndPepper005_Median33,"./assets/saltAndPepper005_Median33.im");
		 System.out.println("saltAndPepper005_Median33:"+CalculateSNR(bytes,saltAndPepper005_Median33,headerLength));
		 WriteOut(saltAndPepper005_Median55,"./assets/saltAndPepper005_Median55.im");
		 System.out.println("saltAndPepper005_Median55:"+CalculateSNR(bytes,saltAndPepper005_Median55,headerLength));
		 WriteOut(saltAndPepper005_Opening_Closing,"./assets/saltAndPepper005_Opening_Closing.im");
		 System.out.println("saltAndPepper005_Opening_Closing:"+CalculateSNR(bytes,saltAndPepper005_Opening_Closing,headerLength));
		 WriteOut(saltAndPepper005_Closing_Opening,"./assets/saltAndPepper005_Closing_Opening.im");
		 System.out.println("saltAndPepper005_Closing_Opening:"+CalculateSNR(bytes,saltAndPepper005_Closing_Opening,headerLength));
		 
	}
	
	public static float CalculateSNR(ArrayList<Integer> originImage,ArrayList<Integer> filterImage,int headerLength)
	{
		float result = 0;
	
		int total = originImage.size() - headerLength;
		
		// calculate us
		float us = 0;
		for(int i = headerLength ; i<originImage.size() ; i++)
		{
			us += originImage.get(i);
		}
		us /= total;
		
		//calculate vs
		float vs = 0;
		for(int i = headerLength ; i<originImage.size() ; i++)
		{
			vs += (originImage.get(i) - us)*(originImage.get(i) - us) ;
		}
		vs/=total;
		
		//calculate un
		float un = 0;
		for(int i = headerLength ; i<originImage.size() ; i++)
		{
			un += (filterImage.get(i) - originImage.get(i)) ;
		}
		un/=total;
		
		//caculate vn
		float vn =0;
		for(int i = headerLength ; i<originImage.size() ; i++)
		{
			float data = filterImage.get(i)-originImage.get(i)-un;
			vn += data*data;
		}
		vn /= total;
		
		result = (float) (20 * Math.log10(Math.sqrt(vs)/Math.sqrt(vn)));
		
		return result;
	}
	
	public static ArrayList<Integer> Opening_Closing(ArrayList<Integer> origin,int headerLength, int width, int height,Kernel kernel)
	{
		ArrayList<Integer> erosion = Erosion(origin,headerLength,width,height,kernel);
		ArrayList<Integer> dilation = Dilation(erosion,headerLength,width,height,kernel);
		dilation = Dilation(dilation,headerLength,width,height,kernel);
		erosion = Erosion(dilation,headerLength,width,height,kernel);
		
		return erosion;
	}
	
	public static ArrayList<Integer> Closing_Opening(ArrayList<Integer> origin,int headerLength, int width, int height,Kernel kernel)
	{
		ArrayList<Integer> dilation = Dilation(origin,headerLength,width,height,kernel);
		ArrayList<Integer> erosion = Erosion(dilation,headerLength,width,height,kernel);
		erosion = Erosion(erosion,headerLength,width,height,kernel);
		dilation = Dilation(erosion,headerLength,width,height,kernel);
		
		return dilation;
	}
	
	public static ArrayList<Integer> Erosion(ArrayList<Integer> origin,int headerLength, int width, int height,Kernel kernel)
	{
		ArrayList<Integer> results = InitWhite(origin,headerLength,width,height);
		
		for(int y = 0 ; y < height - (kernel.GetHeight()-1) ; y++)
		{
			for(int x = 0 ; x<width - (kernel.GetWidth()-1); x++)
			{
				boolean validate = true;
				int min = 255;
				
				for(int y2 = 0 ; y2 < kernel.GetHeight() ; y2 ++)
				{
					for(int x2 =0 ; x2 < kernel.GetWidth() ;x2 ++)
					{
						if(kernel.Data[y2][x2]==1)
						{
							int globalX = x + x2;
							int globalY = y + y2;
							int globalIndex = headerLength+globalY * width + globalX;
							
							if(min>origin.get(globalIndex))min = origin.get(globalIndex);
						}
					}
				}
				
				int globalX = x + kernel.OriginX;
				int globalY = y + kernel.OriginY;
				int globalIndex = headerLength+globalY * width + globalX;
				results.set(globalIndex, min);

			}
		}
		
		return results;
	}
	
	
	
	
	public static ArrayList<Integer> Dilation(ArrayList<Integer> origin,int headerLength, int width, int height,Kernel kernel)
	{
		ArrayList<Integer> results = InitWhite(origin,headerLength,width,height);
		
		for(int y = 0 ; y < height ; y++)
		{
			for(int x = 0 ; x<width ; x++)
			{
				int index = headerLength+width*y+x;
				int max = 0;
				
					for(int y2 = 0 ; y2 < kernel.GetHeight() ; y2++)
					{
						for( int x2 = 0 ; x2 < kernel.GetWidth() ; x2++)
						{
							int localX = x2 - kernel.OriginX;
							int localY = y2 - kernel.OriginY;
							
							int globalX = x + localX;
							int globalY = y + localY;
							
							if(globalX<0)continue;
							if(globalX>=width)continue;
							if(globalY<0)continue;
							if(globalY>=height)continue;
							
							int globalIndex = headerLength + globalY*height + globalX;
							
							if(kernel.Data[y2][x2]==1)
							{
								if(max < origin.get(globalIndex))
								{
									max = origin.get(globalIndex);
								}
							}
						}
						
					results.set(index, max);
				}
			}
		}
		
		return results;
	}

	public static ArrayList<Integer> BoxFilter(ArrayList<Integer> origin,int boxWidth,int boxHeight,int headerLength, int width, int height)
	{
		ArrayList<Integer> results = InitWhite(origin,headerLength,width,height);
		
		for(int y = 0 ; y < height; y++)
		{
			for(int x = 0 ; x < width ; x++)
			{
				int centerX = (boxWidth - 1)/2;
				int centerY = (boxHeight - 1)/2;
				
				ArrayList<Integer> candidate = new ArrayList<Integer>();
				
				for(int boxY = 0; boxY < boxHeight ; boxY++)
				{
					for(int boxX = 0; boxX < boxWidth ; boxX++)
					{
						int globalX = x + boxX - centerX;
						int globalY = y + boxY - centerY;
						
						if(globalX<0)continue;
						if(globalX>=width)continue;
						if(globalY<0)continue;
						if(globalY>=height)continue;
						
						int pixel = origin.get(headerLength + globalY*width + globalX);
						
						candidate.add(pixel);
					}
				}
				
				results.set(headerLength + y * width + x, Average(candidate));
				
			}	
		}
		
		return results;
	}
	
	public static ArrayList<Integer> MedianFilter(ArrayList<Integer> origin,int boxWidth,int boxHeight,int headerLength, int width, int height)
	{
		ArrayList<Integer> results = InitWhite(origin,headerLength,width,height);
		
		for(int y = 0 ; y < height; y++)
		{
			for(int x = 0 ; x < width ; x++)
			{
				int centerX = (boxWidth - 1)/2;
				int centerY = (boxHeight - 1)/2;
				
				ArrayList<Integer> candidate = new ArrayList<Integer>();
				
				for(int boxY = 0; boxY < boxHeight ; boxY++)
				{
					for(int boxX = 0; boxX < boxWidth ; boxX++)
					{
						int globalX = x + boxX - centerX;
						int globalY = y + boxY - centerY;
						
						if(globalX<0)continue;
						if(globalX>=width)continue;
						if(globalY<0)continue;
						if(globalY>=height)continue;
						
						int pixel = origin.get(headerLength + globalY*width + globalX);
						
						candidate.add(pixel);
					}
				}
				
				results.set(headerLength + y * width + x, Median(candidate));
				
			}	
		}
		
		return results;
	}
	
	public static int Average(ArrayList<Integer> list)
	{
		float result = 0;
		
		for(int i = 0 ; i < list.size() ; i++)
		{
			result += list.get(i);
		}
		
		result/= list.size();
		
		return (int)result;
	}
	
	public static int Median(ArrayList<Integer> list)
	{	
		int median = list.size()/2;
		
		list.sort( new Comparator<Integer>() {
          
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		
		return (int)list.get(median);
	}
	
	
	public static ArrayList<Integer> SaltAndPeper(ArrayList<Integer> origin,float threshold,int headerLength, int width, int height)
	{
		ArrayList<Integer> results = InitWhite(origin,headerLength,width,height);
		
		for(int y = 0 ; y < height; y++)
		{
			for(int x = 0 ; x < width ; x++)
			{
				int index = headerLength + y*width + x;
				
				float randomNum = random.nextFloat();
				int pixel = origin.get(index);
				
				if(randomNum < threshold)
				{
					pixel = 0;
				}
				else if(randomNum>(1-threshold))
				{
					pixel = 255;
				}
				
				results.set(index,pixel);
			}
		}
		
		return results;
	}
	
	public static ArrayList<Integer> GaussianNoise( ArrayList<Integer> origin,int amplitude,int headerLength, int width, int height)
	{
		ArrayList<Integer> results = InitWhite(origin,headerLength,width,height);
		
		for(int y = 0 ; y < height; y++)
		{
			for(int x = 0 ; x < width ; x++)
			{
				int index = headerLength + y*width + x;
				
				int pixel = origin.get(index) + (int)(amplitude*random.nextGaussian());
				
				if(pixel<0)pixel = 0;
				
				if(pixel>255)pixel = 255;
				
				results.set(index, pixel);
			}
		}
		
		return results;
	}
	
	public static ArrayList<Integer> InitWhite(ArrayList<Integer> origin,int headerLength, int width, int height)
	{
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		for(int i = 0 ; i < headerLength ; i++)
		{
			results.add(origin.get(i));
		}
		
		for(int i = 0 ; i < width ; i ++)
		{
			for(int j = 0 ; j<height ; j++)
			{
				results.add(0);
			}
		}
		
		return results;
	}

	
	public static ArrayList<Integer> GetByteData(String fileName) throws IOException
	{
		 File f = new File(fileName);
		 ArrayList<Integer> bytes = new ArrayList<Integer>();
		
		 //System.out.println("file exist:"+f.exists());
		
		 FileInputStream in = null;	
		 in = new FileInputStream(fileName);
		 
		 int c;
		 while ((c = in.read()) != -1) {
			 bytes.add(c);
        }
		 
		 return bytes;
	}
	
	public static void WriteOut(ArrayList<Integer> data,String name) throws IOException
	{
		File f = new File(name);
		if(f.exists())f.delete();
		FileOutputStream out = null;
		out = new FileOutputStream(name);
		
		for(int i : data)
		{
			out.write((byte)i);
		}
		
		out.flush();
		out.close();
		
	}
	

}
