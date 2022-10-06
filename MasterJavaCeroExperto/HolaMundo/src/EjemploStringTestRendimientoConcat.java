public class EjemploStringTestRendimientoConcat
{
    public static void main(String[] args) {

        String a="a";
        String b="b";
        String c=a;

        StringBuilder sb=new StringBuilder(a);//Es mutable a diferencia del String que es inmutable
        long inicio=System.currentTimeMillis();


        for (int i=0; i<500;i++){
           // c=c.concat(a).concat(b).concat("\n");//500 == 2ms
            //c+=a+b+"\n";//500 == 19ms
            sb.append(a).append(b).append("\n");////500 == 0ms
        }

        System.gc();//se esta acelerando el proceso pq eso lo hace automaticamente la jvm

        long fin=System.currentTimeMillis();
        System.out.println(fin-inicio);
        System.out.println("c = "+c);
        System.out.println("sb = "+ sb.toString());
        System.exit(0);
    }
}
