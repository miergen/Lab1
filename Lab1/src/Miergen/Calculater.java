package Miergen;//这是第一次修改案例！！！
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculater {
	public String Expression (String index){
		char[] indexes =new char[99];
		indexes=index.toCharArray();
		if (!index.matches("[\\w\\d\\+\\-\\*/]*")||indexes[0]=='-'){//符号和字母限制||第一个字符为负号错误
			System.out.println("Wrong");
			return "";
		}

		else{
			System.out.println(index);
			return index;
			}
	}
	public String simply(String index,String index2){
		Pattern pattern2= Pattern.compile("!simplify$");//如果只输入!simplify的情况
		Matcher output=pattern2.matcher(index);
		if(output.matches()){
			System.out.println(index2);
			return"";
		}		
		Pattern pattern = Pattern.compile("^!simplify [a-zA-Z].*");//输入正确格式的情况
		Matcher matcher = pattern.matcher(index);
		if (matcher.matches()){//System.out.println("Wrong");}
		////////处理赋值函数
		 String[] rindex = index.split(" ");
		 for(int i=1;i<rindex.length;i++){
			 String[] rindex2= rindex[i].split("=");
			 index2 = index2.replace(rindex2[0], rindex2[1]);
		 }
		 
		 System.out.println(index2);
		}
		
		Pattern pattern3= Pattern.compile("^!d/d [a-zA-Z]");//求导函数
		Matcher dvoutput=pattern3.matcher(index);
		if(dvoutput.matches()){
			String [] rindex = index.split(" ");
			String[] rindex2=index2.split("[+]");
			for(int i=0;i<rindex2.length;i++){
				int count=0;
				String []change=rindex2[i].split("[*]");
				for(int j=0;j<change.length;j++){
			
				if(change[j].charAt(0) == rindex[1].charAt(0))//求出系数
				{
					count=count+1;
				}
				}
				if (count==0){///////////////////////////////判断倘若无参数
					
					rindex2[i]="0";
	
					
				}
				else{String ch1=String.valueOf(count);
				rindex2[i]=rindex2[i].replaceFirst(rindex[1],ch1);
				}//用系数替换参数
				if(rindex2[i]!="0"){
					System.out.print(rindex2[i]+"+");
				}//输出格式
			

			}		
		}
			return "ok";
}
	

	public static void main(String[] args) {
				System.out.println("input you Expression:");
				Calculater nb=new Calculater();
				Scanner input= new Scanner(System.in);		
				
				String index=input.nextLine();
				String reindex=nb.Expression(index);//识别输入是否正确！
		
				
				Scanner input2= new Scanner(System.in);	
				String index2=input.nextLine();
	

				
				

				
			
				nb.simply(index2,reindex);//化简
				input.close();input2.close();
				System.out.print("0");//为了输出美观

		// TODO Auto-generated method stub

	}

}
// B1 change!