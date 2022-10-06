public class AutoboxngInteger {
    public static void main(String[] args) {

        Integer[] enteros={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
       //Otras fornas de declarar
        // Integer[]enteros2={Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3)};
       // Integer[]enteros3=new Integer[9];

        int suma=0;
        for (Integer i:enteros) {
            if (i%2==0){
                suma+=i;//hace el unoboxing
            }
        }

        System.out.println("suma = " + suma);

        suma=0;
        for (Integer i:enteros) {
            if (i.intValue()%2==0){
                suma+=i.intValue();
            }
        }
        System.out.println("suma = " + suma);
    }
}
