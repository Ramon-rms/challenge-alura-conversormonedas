import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in); //lectura es ahora el nombre de SCANNER
        //Instanciando

        while (true) { //Inicializando el conversor y dando opción de salir
            System.out.print("Ingrese el código de moneda a convertir (por ejemplo USD), o escriba SALIR para terminar: \n");
            System.out.println("**********CÓDIGOS DE MONEDA**********\n-Peso Argentino: ARS \n-Peso Mexicano: MXN \n-Dólar EEUU: USD \n");
            System.out.println("*************************************");
            String monedaOrigen = lectura.nextLine().toUpperCase();

            if (monedaOrigen.equals("SALIR")) {
                System.out.println("Saliendo...");
                break;
            }

            // Verificar si la moneda de origen es válida
            if (!monedaOrigen.equals("ARS") && !monedaOrigen.equals("MXN") && !monedaOrigen.equals("USD")) {
                System.out.println("Error: Código de moneda origen no válido. Intente nuevamente.");
                continue;
            }

            System.out.println("Ingrese el código de moneda destino: ");
                String monedaDestino = lectura.nextLine().toUpperCase();

                if (!monedaDestino.equals("ARS") && !monedaDestino.equals("MXN") && !monedaDestino.equals("USD")) {
                System.out.println("Error: Código de moneda origen no válido. Intente nuevamente.");
                continue;
                }

            System.out.println("Ingrese el monto de moneda origen que desea convertir: ");
                double monto = lectura.nextDouble();
                if (monto == 0) {
                    System.out.println("El monto es 0");
                    break;
                }
                    lectura.nextLine(); //Para hacer salto de línea y asegurar no salga el mensaje de Exception

                System.out.println("Consultando tasas de cambio para " + monedaOrigen + "...");
                Moneda datosMoneda;
                try {
                    datosMoneda = ConsultaMoneda.buscaMoneda(monedaOrigen);
                    double tasaOrigen = datosMoneda.getConversionRates().get(monedaOrigen);
                    double tasaDestino = datosMoneda.getConversionRates().get(monedaDestino);
                    double montoConvertido = monto * (tasaDestino / tasaOrigen);
                    System.out.println("El monto de " + monto + " " + monedaOrigen + " es igual a " + montoConvertido + " " + monedaDestino + "\n");
                } catch (RuntimeException e) {
                    System.out.println("Error: " + e.getMessage());
                    return;
                }
            }
        }
    }