package umg.edu.progra.arboles;

public class Principal {

    public static void main(String[] args) {

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        int[] valores = { 50, 30, 70, 20, 40, 60, 80, 10 };
        for (int v : valores) {
            arbol.insertar(v);
        }

        System.out.println("===== Arbol Binario de Busqueda =====");
        System.out.println("Tamanio: " + arbol.tamanio());
        System.out.println("Altura:  " + arbol.altura());
        System.out.println("Minimo:  " + arbol.minimo());
        System.out.println("Maximo:  " + arbol.maximo());
        System.out.println("Hojas:   " + arbol.contarHojas());

        System.out.println("\n--- Problema 1: contarNodos ---");
        System.out.println("Nodos recursivos: " + arbol.contarNodos());
        System.out.println("Coincide con tamanio? " + (arbol.contarNodos() == arbol.tamanio()));

        System.out.println("\n--- Representacion visual (rotada 90 grados) ---");
        arbol.imprimirArbol();

        System.out.println("\n--- Recorridos ---");
        System.out.print("InOrden    (ascendente): ");
        arbol.inOrden();

        System.out.print("PreOrden   (raiz primero): ");
        arbol.preOrden();

        System.out.print("PostOrden  (raiz al final): ");
        arbol.postOrden();

        System.out.print("Por niveles (BFS):         ");
        arbol.recorridoPorNiveles();

        System.out.println("\n--- Busquedas ---");
        System.out.println("Contiene 40? " + arbol.contiene(40));
        System.out.println("Contiene 99? " + arbol.contiene(99));

        System.out.println("\n--- Eliminacion ---");
        System.out.println("Eliminando 20 (nodo con 1 hijo)...");
        arbol.eliminar(20);
        System.out.print("InOrden tras eliminar 20: ");
        arbol.inOrden();

        System.out.println("Eliminando 30 (nodo con 2 hijos)...");
        arbol.eliminar(30);
        System.out.print("InOrden tras eliminar 30: ");
        arbol.inOrden();

        System.out.println("Eliminando 50 (raiz)...");
        arbol.eliminar(50);
        System.out.print("InOrden tras eliminar la raiz: ");
        arbol.inOrden();

        System.out.println("\n--- Estado final ---");
        arbol.imprimirArbol();
        System.out.println("Tamanio final: " + arbol.tamanio());
        System.out.println("Altura final:  " + arbol.altura());

        System.out.println("\n--- Problema 1 despues de eliminar ---");
        System.out.println("Nodos recursivos final: " + arbol.contarNodos());
        System.out.println("Coincide con tamanio final? " + (arbol.contarNodos() == arbol.tamanio()));

        System.out.println("\n--- Problema 2: esBalanceado ---");

        ArbolBinarioBusqueda balanceado = new ArbolBinarioBusqueda();
        balanceado.insertar(50);
        balanceado.insertar(30);
        balanceado.insertar(70);
        balanceado.insertar(20);
        balanceado.insertar(40);
        balanceado.insertar(60);
        balanceado.insertar(80);

        System.out.println("Arbol balanceado? " + balanceado.esBalanceado());

        ArbolBinarioBusqueda desbalanceado = new ArbolBinarioBusqueda();
        desbalanceado.insertar(1);
        desbalanceado.insertar(2);
        desbalanceado.insertar(3);
        desbalanceado.insertar(4);
        desbalanceado.insertar(5);

        System.out.println("Arbol desbalanceado? " + desbalanceado.esBalanceado());

        System.out.println("\n--- Problema 3: esBSTValido ---");

        ArbolBinarioBusqueda bstValido = new ArbolBinarioBusqueda();
        bstValido.insertar(50);
        bstValido.insertar(30);
        bstValido.insertar(70);
        bstValido.insertar(20);
        bstValido.insertar(40);
        bstValido.insertar(60);
        bstValido.insertar(80);

        System.out.println("Arbol BST valido? " + bstValido.esBSTValido());

        ArbolBinarioBusqueda bstRoto = new ArbolBinarioBusqueda();
        bstRoto.insertar(50);
        bstRoto.insertar(30);
        bstRoto.insertar(70);

        bstRoto.getRaiz().izquierdo.dato = 90;

        System.out.println("Arbol BST roto? " + bstRoto.esBSTValido());

        System.out.println("\n--- Problema 4: ancestroComunMasBajo ---");

        ArbolBinarioBusqueda lca = new ArbolBinarioBusqueda();
        lca.insertar(50);
        lca.insertar(30);
        lca.insertar(70);
        lca.insertar(20);
        lca.insertar(40);
        lca.insertar(60);
        lca.insertar(80);
        lca.insertar(10);

        System.out.println("LCA de 10 y 40: " + lca.ancestroComunMasBajo(10, 40));
        System.out.println("LCA de 10 y 80: " + lca.ancestroComunMasBajo(10, 80));
        System.out.println("LCA de 60 y 80: " + lca.ancestroComunMasBajo(60, 80));

        try {
            System.out.println("LCA de 10 y 99: " + lca.ancestroComunMasBajo(10, 99));
        } catch (IllegalArgumentException e) {
            System.out.println("LCA de 10 y 99: " + e.getMessage());
        }
    }
}