package fecha;

import utiles.Teclado;
public class TestFecha {


  public static void main(String[] args) {
    
    int dia = Teclado.leeEntero("Introduce el dia.");
    int mes = Teclado.leeEntero("Introduce el mes.");
    int anio = Teclado.leeEntero("Introduce el anio.");
    Fecha f1 = new Fecha(dia,mes, anio);
    
    int dia2 = Teclado.leeEntero("Introduce el dia.");
    int mes2 = Teclado.leeEntero("Introduce el mes.");
    int anio2 = Teclado.leeEntero("Introduce el anio.");
    Fecha f2 = new Fecha(dia2,mes2,anio2);
    
    System.out.println("Fecha 1: " + f1);
    System.out.println("Fecha 2: " + f2);
    System.out.println("¿Es la fecha introducida correcta?: " + f1.fechaCorrecta(dia, mes, anio));
    System.out.println("¿Es la fecha introducida correcta?: " + f2.fechaCorrecta(dia, mes, anio));
    System.out.println("¿Son las fechas iguales?: " + f1.igualQue(f2));
    System.out.println("¿Es la primera fecha mayor que la segunda?: " + f1.mayorQue(f2));
    System.out.println("¿Es la primera fecha menor que la segunda?: " + f1.menorQue(f2));
    System.out.println("Fecha mas 1 dia: " + f1.fechaMas1Dia());
    System.out.println("Fecha menos 1 dia: " + f1.fechaMenos1Dia());
    System.out.println("Fecha mas 10 dias: " + f1.fechaMasNDias(10));
    System.out.println("Fecha menos 31 dias: " + f1.fechaMenosNDias(31));
  
    
    
     

  }

}