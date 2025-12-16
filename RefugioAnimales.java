import java.util.*;

public class RefugioAnimales {
    // Estructuras de datos
    static List<String> animales = new ArrayList<>();
    static Map<String, String> estadoAnimal = new HashMap<>();
    static Set<String> especies = new HashSet<>();
    static Map<String, String> animalEspecie = new HashMap<>();
    static String[] estados = {"Disponible", "Adoptado"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // Menú principal
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrarAnimal(sc);
                    break;
                case 2:
                    registrarEspecie(sc);
                    break;
                case 3:
                    marcarAdoptado(sc);
                    break;
                case 4:
                    mostrarDisponibles();
                    break;
                case 5:
                    mostrarAdoptados();
                    break;
                case 6:
                    reporteGeneral();
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 7);
        sc.close();
    }

    // Mostrar menú
    public static void mostrarMenu() {
        System.out.println("REFUGIO DE ANIMALES");
        System.out.println("1. Registrar animal");
        System.out.println("2. Registrar especie");
        System.out.println("3. Marcar animal como adoptado");
        System.out.println("4. Mostrar animales disponibles");
        System.out.println("5. Mostrar animales adoptados");
        System.out.println("6. Mostrar reporte general");
        System.out.println("7. Salir");
        System.out.print("Elige una opción: ");
    }

    // Opción 1: Registrar animal
    public static void registrarAnimal(Scanner sc) {
        System.out.print("Nombre del animal: ");
        String nombreAnimal = sc.nextLine();
        if (animales.contains(nombreAnimal)) {
            System.out.println("¡Error! El animal ya está registrado.");
            return;
        }

        System.out.print("Especie del animal: ");
        String especie = sc.nextLine();
        if (!especies.contains(especie)) {
            System.out.println("¡Error! La especie no está registrada.");
            return;
        }

        animales.add(nombreAnimal);
        estadoAnimal.put(nombreAnimal, "Disponible");
        animalEspecie.put(nombreAnimal, especie);
        System.out.println("Animal registrado con éxito.");
    }

    // Opción 2: Registrar especie
    public static void registrarEspecie(Scanner sc) {
        System.out.print("Nombre de la especie: ");
        String especie = sc.nextLine();
        especies.add(especie);
        System.out.println("Especie registrada con éxito.");
    }

    // Opción 3: Marcar animal como adoptado
    public static void marcarAdoptado(Scanner sc) {
        System.out.println("Animales disponibles:");
        for (String animal : animales) {
            if (estadoAnimal.get(animal).equals("Disponible")) {
                System.out.println(animal);
            }
        }

        System.out.print("Ingresa el nombre del animal adoptado: ");
        String animalAdoptado = sc.nextLine();
        if (!estadoAnimal.containsKey(animalAdoptado) || estadoAnimal.get(animalAdoptado).equals("Adoptado")) {
            System.out.println("¡Error! El animal no está disponible para adopción.");
            return;
        }

        estadoAnimal.put(animalAdoptado, "Adoptado");
        System.out.println("El animal ha sido marcado como adoptado.");
    }

    // Opción 4: Mostrar animales disponibles
    public static void mostrarDisponibles() {
        System.out.println("Animales disponibles:");
        for (String animal : animales) {
            if (estadoAnimal.get(animal).equals("Disponible")) {
                System.out.println(animal);
            }
        }
    }

    // Opción 5: Mostrar animales adoptados
    public static void mostrarAdoptados() {
        System.out.println("Animales adoptados:");
        for (String animal : animales) {
            if (estadoAnimal.get(animal).equals("Adoptado")) {
                System.out.println(animal);
            }
        }
    }

    // Opción 6: Mostrar reporte general
    public static void reporteGeneral() {
        int disponibles = 0;
        int adoptados = 0;

        System.out.println("Reporte general:");
        System.out.println("Nombre | Especie | Estado");
        for (String animal : animales) {
            String especie = animalEspecie.get(animal);
            String estado = estadoAnimal.get(animal);
            System.out.println(animal + " | " + especie + " | " + estado);

            if (estado.equals("Disponible")) {
                disponibles++;
            } else {
                adoptados++;
            }
        }

        System.out.println("\nTotal de animales: " + animales.size());
        System.out.println("Total disponibles: " + disponibles);
        System.out.println("Total adoptados: " + adoptados);
    }
}
