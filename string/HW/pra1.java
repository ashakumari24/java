
    import java.io.* ;

class pra1 {
	public static void main(String args[])
	{
		// StringBuffer sb = new StringBuffer("Hello ");
		// sb.append("Java"); // now original string is changed
		// System.out.println(sb);
        StringBuffer sb = new StringBuffer("Hello ");
        sb.insert(1, "Java");
        // Now original string is changed
        System.out.println(sb);
	}
}


