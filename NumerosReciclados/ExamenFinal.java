import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
public class ExamenFinal {
static int[][] cad;
static String[][] cad1;
static int cadena;
static String ruta="";
static String ruta1="";
static String ruta2="";
    public static void main(String[] args) {
       ruta=args[0];
       leer();
       /*for(int i=0;i<cadena;i++){
           System.out.println(cad[i][0]+" "+cad[i][1]);
       }*/
       String[] t;
       String p;
       int c=0;
       int numero=0;
       String pp="";
       String a="";
       int n=0;
       int contador=0;
       cad1=new String[cadena][4];
       
       for(int i=0;i<cadena;i++){
           cad1[i][0]="Caso #"+(i+1)+":";
           cad1[i][1]="";
           cad1[i][2]="";
           cad1[i][3]="";
       }
       for(int i=0;i<cadena;i++){
          
           String[] cad2=new String[cad[i][1]];
           for(int q=0;q<cad[i][1];q++){
           cad2[q]="";
           }
           for(int j=cad[i][0];j<=cad[i][1];j++){
               p=Integer.toString(j);
               t=new String[p.length()];
               for(int x=0;x<p.length();x++){
                   pp=pp+p.charAt(x);
                   t[x]=pp; 
                   pp="";
               }
               Boolean v=false;
               Boolean vv=false;
               int f=p.length()-1;
               
               if(f>0){
               n=cad[i][0];
               
               do{
                   a="";
                   a=a+t[f];
                   for(int y=0;y<=f-1;y++){
                       a=a+t[y];
                   }
                   while(n!=cad[i][1]){
                       if(n==Integer.parseInt(a)){
                          if(t[0].equals(t[1])){
                              
                              v=true;
                              break;
                           }
                           for(int ii=0;ii<cad[i][1];ii++){
                               if(cad2[ii].equals(a)){
                                  vv=true; 
                               }
                           }
                           if(vv==false){
                           v=true;
                           cad2[c]=a;
                           c++;
                           cad2[c]=p;
                           c++;
                           contador++;
                           break;
                           }else{
                               v=true;
                               break;
                           }
                       }else if(a.charAt(0)=='0'){
                           v=true;
                           break;
                       }else{
                           v=true;
                           n++;
                       }
                   }
               }while(v==false);
               
               }
           }
           cad1[i][1]=Integer.toString(contador);
           contador=0;
           c=0;
       
       }
       for(int i=0;i<cadena;i++){
           System.out.println(cad1[i][0]+" "+cad1[i][1]);
       }
       guardar();
    }
    
    public static void leer(){
        try {
        File f1 = new File(ruta); 
        BufferedReader reader1 = new BufferedReader(new FileReader(f1)); 
        String line1 = null; 
        int contador1 = 0;
        int cont=0;
        cadena=0;
        String cadena1="";
        line1=reader1.readLine();
        cadena=Integer.parseInt(line1);
        cad=new int[cadena][2];
        while (cont!=cadena) {
        line1=reader1.readLine();
        contador1 = 0;
        for(int i=0;i<line1.length();i++){
        
        while(i!=line1.length()){
        if(line1.charAt(i)!= ' '){
        cadena1 = cadena1 +line1.charAt(i);
        i++;
        }else{
            break;
        }
        }  
        
        
        cad[cont][contador1]=Integer.parseInt(cadena1);
        cadena1="";
        contador1 ++;
        }
        cont++;
        }
        }catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "No se Pudo Cargar '" + "'","Error de Escritura",JOptionPane.ERROR_MESSAGE);  						
  	}
    }
    
    public static void guardar(){
        String dato="";
        for(int x=0;x<ruta.length();x++){
            while(ruta.charAt(x)!='\\'){       
            if(x<ruta.length()){
            ruta1=ruta1+ruta.charAt(x);
            x++;
            if(x==ruta.length()){
                break;
            }
            }else{
                break;
            }
            }
            if(ruta1.equals("dataset1.txt")){
                ruta1="";
            }else if(ruta1.equals("dataset2.txt")){
                ruta1="";
            }else{
            ruta2=ruta2+ruta1+"\\";
            ruta1="";
            }
        }
        try{
		File file = new File (ruta2+"ExamenFinal_201212640.txt");
    		FileWriter escribir = new FileWriter(file);
                for(int i=0;i<cadena;i++){
                for(int j=0;j<2;j++){
                    dato=dato+""+cad1[i][j]+" ";
                }
                escribir.write(dato);
                
                dato="";
                }
                escribir.close();
    		}
  		catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "No se Pudo Guardar ''","Error de Escritura",JOptionPane.ERROR_MESSAGE);  						
  		}
    }
}
