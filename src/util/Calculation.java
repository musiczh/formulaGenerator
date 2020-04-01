package util;


import java.util.LinkedList;

public class Calculation {


	public static String getResult(String string) {

		String[] strings=string.split("\\s+");
		String c;
		LinkedList<String> statck=new LinkedList<>(),
				output=new LinkedList<>();
		//鏉烆剚宕叉稉鍝勬倵缂傦拷瀵拷
		for(int i=0;i<strings.length;i++) {
			String[] a=strings[i].split("/");
			if(a.length>1) {//閺勵垱鏆熺�涳拷
				output.add(strings[i]);
				/**output.add(a[0]);
				 output.add(a[1]);
				 output.add("/");**/
				continue;
			}else {
				if(a[0].equals("÷"))a[0]="/";
				if(a[0].equals("×"))a[0]="*";
				if(a[0].equals(")")) {
					while(!statck.isEmpty()&&!(c=statck.removeFirst()).equals("(")) {
						output.add(c);
					}
					continue;
				}
				while(!statck.isEmpty()&&!isBigger(a[0],statck.getFirst())) {
					if(statck.getFirst().equals("("))break;
					while(!statck.isEmpty()&&!(c=statck.removeFirst()).equals("(")) {
						output.add(c);
					}

				}
				statck.addFirst(a[0]);

			}
		}
		while(!statck.isEmpty()) {
			output.add(statck.removeFirst());
		}


		return result(statck,output);
	}


	private static String result(LinkedList<String> statck, LinkedList<String> output) {
		int number,zero='0';
		String s;
		String[] c1,c2;
		for(int i=0;i<output.size();i++) {
			String[] strings=output.get(i).split("/");
			if(strings.length>1) {
				statck.addFirst(output.get(i));
			}else {
				c2=statck.removeFirst().split("/");
				c1=statck.removeFirst().split("/");
				s=output.get(i);
				if(s.equals("+")) {
					statck.addFirst((Integer.parseInt(c1[0])*Integer.parseInt(c2[1])+Integer.parseInt(c2[0])*Integer.parseInt(c1[1]))+"/"+(Integer.parseInt(c2[1])*Integer.parseInt(c1[1])));
				}else if(s.equals("-")){
					statck.addFirst((Integer.parseInt(c1[0])*Integer.parseInt(c2[1])-Integer.parseInt(c2[0])*Integer.parseInt(c1[1]))+"/"+(Integer.parseInt(c2[1])*Integer.parseInt(c1[1])));
				}else if(s.equals("*")){
					statck.addFirst(Integer.parseInt(c1[0])*Integer.parseInt(c2[0])+"/"+Integer.parseInt(c1[1])*Integer.parseInt(c2[1]));
				}else if(s.equals("/")){
					if(Integer.parseInt(c1[1])*Integer.parseInt(c2[0])==0)return null;
					statck.addFirst(Integer.parseInt(c1[0])*Integer.parseInt(c2[1])+"/"+Integer.parseInt(c1[1])*Integer.parseInt(c2[0]));
				}
				c1=statck.getFirst().split("/");
				if(Integer.parseInt(c1[0])*Integer.parseInt(c1[1])<0) {//婵″倹鐏夌亸蹇庣艾0閿涘矂鍋呮稊鍫熸箒娑撳閲滅�涙顑�
					return null;
				}
			}
		}

		return statck.getFirst()+"";
	}


	private static boolean isBigger(String s1,String s2) {
		if(s1.equals("(")) {
			return true;
		}
		if(s2.equals("+")||s2.equals("-")) {
			if(s1.equals("*")||s1.equals("/"))return true;
		}
		return false;
	}
}
