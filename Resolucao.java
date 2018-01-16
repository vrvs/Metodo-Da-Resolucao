import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Resolucao {
	
	public static boolean FNC(String expr, int begin) {
		int a = 0;
		for(int i=0;i<expr.length();i++) {
			if(expr.charAt(i)=='(') a++; 
			if(expr.charAt(i)==')') a--; 
			if(a>1) return false;
			if(a==0&&(!(expr.charAt(i)=='.'||expr.charAt(i)==')'))) return false;
			if(a==1&&(!(expr.charAt(i)=='a'||expr.charAt(i)=='b'||expr.charAt(i)=='c'||expr.charAt(i)=='d'||expr.charAt(i)=='+'||expr.charAt(i)==')'||expr.charAt(i)=='-'||expr.charAt(i)=='('))) return false;	
		}
		return true;
	}
    
	public static boolean horn(String expr){
		int count1=0,count2=0;
		for(int i=0; i<expr.length();i++) {
			if(expr.charAt(i)=='a'||expr.charAt(i)=='b'||expr.charAt(i)=='c'||expr.charAt(i)=='d') count1++;
			else if(expr.charAt(i)=='-') count2++;
			else if(expr.charAt(i)=='(') {count1 = 0; count2 = 0;} 
			else if(expr.charAt(i)==')') {
				i++;
				if((count1-count2)>1)	return false;
			}
		}
		return true;
	}
	
	public static String simplifyNewClause(String clause) {
		String result;
		int a=0,b=0,c=0,d=0,na=0,nb=0,nc=0,nd=0;
		for(int j=1;j<clause.length()-1;j++) {
			if(clause.charAt(j)=='e') na=1;
			else if(clause.charAt(j)=='f') nb=1;
			else if(clause.charAt(j)=='g') nc=1;
			else if(clause.charAt(j)=='h') nd=1;
			else if(clause.charAt(j)=='a') a=1;
			else if(clause.charAt(j)=='b') b=1;
			else if(clause.charAt(j)=='c') c=1;
			else if(clause.charAt(j)=='d') d=1;
		}
		result="(";
		if(a==1) result=result+"a+";
		if(b==1) result=result+"b+";
		if(c==1) result=result+"c+";
		if(d==1) result=result+"d+";
		if(na==1) result=result+"e+";
		if(nb==1) result=result+"f+";
		if(nc==1) result=result+"g+";
		if(nd==1) result=result+"h+";
		if(!result.equals("(")) result = result.substring(0, result.length()-1);
		result=result+")";
		return result;
	}
	
	public static String simplify(String clause) {
		String result;
		int a=0,b=0,c=0,d=0,na=0,nb=0,nc=0,nd=0;
		for(int j=1;j<clause.length()-1;j++) {
			if(clause.charAt(j)=='-') {
				j++;
				if(clause.charAt(j)=='a') na=1;
				else if(clause.charAt(j)=='b') nb=1;
				else if(clause.charAt(j)=='c') nc=1;
				else if(clause.charAt(j)=='d') nd=1;
				j++;
				
			} else if(clause.charAt(j)=='a') a=1;
			else if(clause.charAt(j)=='b') b=1;
			else if(clause.charAt(j)=='c') c=1;
			else if(clause.charAt(j)=='d') d=1;
		}
		result="(";
		if(a==1) result=result+"a+";
		if(b==1) result=result+"b+";
		if(c==1) result=result+"c+";
		if(d==1) result=result+"d+";
		if(na==1) result=result+"e+";
		if(nb==1) result=result+"f+";
		if(nc==1) result=result+"g+";
		if(nd==1) result=result+"h+";
		result = result.substring(0, result.length()-1);
		result=result+")";
		return result;
	}
	
	public static String[] simplifyExpressions(Vector vec) {
		String[] arr = new String[vec.size()];
		vec.toArray(arr);
		for(int i=0;i<arr.length;i++) arr[i] = simplify(arr[i]);
		return arr;
	}

	public static boolean insatisfativel(String expr) {
		Vector<String> vec = new Vector<String>();
		int begin = 0;
		for(int i=0;i<expr.length();i++) {
			if(expr.charAt(i)=='(') begin = i; 
			if(expr.charAt(i)==')') vec.add(expr.substring(begin, i+1));
		}
		String[] arr = simplifyExpressions(vec);
		vec.clear();
		for(int i=0;i<arr.length;i++) {
			vec.add(arr[i]);
		}
		String newClause;
		boolean cond;
		for(int i=0;i<vec.size();i++) {
			for(int j=0;j<vec.size();j++) {
				if(i!=j){
					newClause = newClause(vec.get(i),vec.get(j));
					newClause = simplifyNewClause(newClause);
					cond = true;
					if(newClause.equals("()")) return true;
					for(int k=0;k<vec.size()&&cond;k++) if(newClause.equals(vec.get(k))) cond = false;
					if(cond) vec.add(newClause);
				}
			}
		}
		return false;
	}
	
	public static String newClause(String c, String d) {
		char[] a = c.toCharArray();
		char[] b = d.toCharArray();
		boolean cond= true;
		for(int i=1;i<a.length-1&&cond;i++) {
			for(int j=1;j<b.length-1&&cond;j++) {
				if((a[i]=='a'&&b[j]=='e')||(a[i]=='e'&&b[j]=='a')) {a[i]='#';b[j]='#';cond = false;}
				if((a[i]=='b'&&b[j]=='f')||(a[i]=='f'&&b[j]=='b')) {a[i]='#';b[j]='#';cond = false;}
				if((a[i]=='c'&&b[j]=='g')||(a[i]=='g'&&b[j]=='c')) {a[i]='#';b[j]='#';cond = false;}
				if((a[i]=='d'&&b[j]=='h')||(a[i]=='h'&&b[j]=='d')) {a[i]='#';b[j]='#';cond = false;}
			}
		}
		String result = "(";
		cond= true;
		for(int i=1;i<a.length-1;i++) {
			if(a[i]!='#'&&a[i]!='+') result = result +a[i]+"+";
			if(a[i]=='#') cond = false;
		}
		for(int i=1;i<b.length-1;i++) {
			if(b[i]!='#'&&b[i]!='+') result = result +b[i]+"+";
		}
		if(!result.equals("(")) result = result.substring(0, result.length()-1);
		result = result+")";
		if(cond) result = c;
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("Expressoes.in");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("Expressoes.out");
		BufferedWriter bw = new BufferedWriter(fw);
		int n = Integer.parseInt(br.readLine());
		String expr;
		int i = 1;
		while(n>0) {
			expr = br.readLine();
			if(!FNC(expr, 0)) {
				bw.write("caso #"+i+": nao esta na FNC");
			} else if(!horn(expr)) {
				bw.write("caso #"+i+": nem todas as clausulas sao de horn");
			} else if(insatisfativel(expr)){
				bw.write("caso #"+i+": insatisfativel");
			} else {
				bw.write("caso #"+i+": satisfativel");
			}
			i++;
			n--;
			bw.newLine();
		}
		bw.close();
		br.close();
		fw.close();
		fr.close();
	}
}
