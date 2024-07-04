package Arreglos;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);

        // variables
        String nombre; // nombre del colaborador
        String incidencia; // datos de la incidencia
        String NiveldeTicket; // nivel del ticket
        int Opcion; // opcion a elegir
        int NumeroDeTicket=104; // iniciando el ticket con 104
        int TicketAAnular; // Ticket a cerrar
        int BuscarNumeroDeTicket; // buscar numero de ticket
        boolean continuar = true; // boolean que indica que cantidad es verdadero.
        String Respuesta; // respuesta si continua el proceso o no.
        LocalTime horaInicial = LocalTime.of(13, 30); // Hora inicial: 13:30

        // Creacion de Listas
        List<Integer>ListaTicket = new ArrayList<>();
        List<String>ListaDatosColaborador = new ArrayList<>();
        List<String>ListaIncidencia = new ArrayList<>();
        List<String>ListaNivveldeIncidencia = new ArrayList<>();
        List<Integer>ListaTicketAnulados = new ArrayList<>();
        List<LocalTime>ListaHoraDeAtencion = new ArrayList<>();


        // Añadiendo datos a la lista de tickets
        ListaTicket.add(101);
        ListaTicket.add(102);
        ListaTicket.add(103);
        ListaTicket.add(104);

        // Añadiendo datos a la lista de colaboradores
        ListaDatosColaborador.add("Bryan Flores");
        ListaDatosColaborador.add("Jhon Rivera");
        ListaDatosColaborador.add("Cesar Zapata");
        ListaDatosColaborador.add("Ethan Tenorio");

        // Añadiendo datos a la lista de incidencias
        ListaIncidencia.add("Error en sap");
        ListaIncidencia.add("Error en excel");
        ListaIncidencia.add("Error en power bi");
        ListaIncidencia.add("Error en SQL");

        // Añadiendo datos a la lista de niveles de incidencia
        ListaNivveldeIncidencia.add("Alto");
        ListaNivveldeIncidencia.add("Alto");
        ListaNivveldeIncidencia.add("Medio");
        ListaNivveldeIncidencia.add("Bajo");

        // Añadiendo Horas de atencion de tickets

        ListaHoraDeAtencion.add(LocalTime.of(9, 30));
        ListaHoraDeAtencion.add(LocalTime.of(10, 30));
        ListaHoraDeAtencion.add(LocalTime.of(11, 30));
        ListaHoraDeAtencion.add(LocalTime.of(12, 30));

        // Eligiendo opciones
        System.out.println("********BIENVENIDO USUARIO********");
        System.out.println("Ingrese opcion");
        System.out.println("1.Crear");
        System.out.println("2.Cerrar ticket");
        System.out.println("3.Tickets abiertos");
        System.out.println("4.Tickets cerrados");
        System.out.println("5.Buscar ticket");
        System.out.print("Ingrese respuesta: ");
        Opcion=entrada.nextInt();

        //Consumir el salto de línea pendiente después de nextInt()
        entrada.nextLine();

    while(continuar) { // Mientras que continuar sea True se dará el ciclo
        switch (Opcion) { // Creamos un switch para las opciones
            case 1:// CREAR TICKETS DE INCIDENCIA
                NumeroDeTicket = NumeroDeTicket + 1; // Aumentar en 1 el valor del numero de ticket.
                ListaTicket.add(NumeroDeTicket);
                System.out.print("ingrese nombre: ");
                nombre = entrada.nextLine();
                ListaDatosColaborador.add(nombre);
                System.out.print("incidencia : ");
                incidencia = entrada.nextLine();
                ListaIncidencia.add(incidencia);
                System.out.print("Nivel de ticket, alto, medio o bajo: ");
                NiveldeTicket = entrada.nextLine();
                ListaNivveldeIncidencia.add(NiveldeTicket);
                // Hacer si el valor es alto, medio o bajo //
                if(NiveldeTicket.equals("alto")){
                    LocalTime horaSumada=horaInicial.plusHours(1);
                    ListaHoraDeAtencion.add(horaSumada);
                    horaInicial = horaInicial.plusHours(1);
                } else if (NiveldeTicket.equals("medio")) {
                    LocalTime horaSumada=horaInicial.plusHours(3);
                    ListaHoraDeAtencion.add(horaSumada);
                    horaInicial = horaInicial.plusHours(3);
                } else if (NiveldeTicket.equals("bajo")) {
                    LocalTime horaSumada=horaInicial.plusHours(5);
                    ListaHoraDeAtencion.add(horaSumada);
                    horaInicial = horaInicial.plusHours(5);
                }
                System.out.println("Se creó el ticket : " + NumeroDeTicket);
                break;
            case 2:// CERRAR UN TICKET DE SOLICITUD.
                System.out.print("Favor de digitar el N° de ticket a cerrar: ");
                TicketAAnular = entrada.nextInt();
                entrada.nextLine();
                int PalabraAnular=0;
                ListaTicketAnulados.add(TicketAAnular);
                for(int i=0;i<ListaTicket.size();i++){
                    if(ListaTicket.get(i)==TicketAAnular){
                        ListaTicket.set(i,PalabraAnular);
                    }
                }
                break;
            case 3: // Mostrar Lista de ticket abiertos
                System.out.println("Tickets pendientes: " + ListaTicket);
                break;
            case 4: // Mostrar lista de tickets cerrados
                System.out.println("Tickets cerrados: " + ListaTicketAnulados);
                break;
            case 5:// Buscar ticket y mostrar todos sus datos.
                System.out.print("Ingresar numero de ticket:");
                BuscarNumeroDeTicket=entrada.nextInt();
                entrada.nextLine();
                for(int j=0;j<ListaTicket.size();j++) { // Recorrer la lista de tickets
                    if (ListaTicket.get(j) == BuscarNumeroDeTicket) { // si el N° de ticket está dentro de la lista de tickets
                        System.out.println("****** DATOS DEL TICKET ******");
                        System.out.println("Ticket: " + ListaTicket.get(j));
                        System.out.println("Colaborador: " + ListaDatosColaborador.get(j));
                        System.out.println("Incidencia: " + ListaIncidencia.get(j));
                        System.out.println("Nivel de incidencia: " + ListaNivveldeIncidencia.get(j));
                        System.out.println("Hora de termino del ticket: " + ListaHoraDeAtencion.get(j));
                        System.out.println("*******************************");
                    }
                }
                break;
            default: // de elegir un numero no contenido dentro de las opciones.
                System.out.println("Opción no válida. Por favor ingresar otra opcion.");
                break;
        }
        // Preguntar si desea continuar
        System.out.print("¿Desea continuar? (si/no): ");
        Respuesta = entrada.nextLine();
        if (Respuesta.equals("no")) {
            continuar = false;
            System.out.println("Programa finalizado.");
            entrada.close();
        }else {
            System.out.println("********BIENVENIDO USUARIO********");
            System.out.println("ingrese opcion");
            System.out.println("1.Crear");
            System.out.println("2.Cerrar tickets");
            System.out.println("3.Tickets abiertos");
            System.out.println("4.Tickets cerrados");
            System.out.println("5.Buscar ticket");
            System.out.print("ingrese respuesta: ");
            Opcion = entrada.nextInt();
            entrada.nextLine();
        }
    }
    }
}
