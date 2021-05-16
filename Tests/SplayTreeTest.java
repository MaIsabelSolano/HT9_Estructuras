import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplayTreeTest {

    @Test
    void put() {
        SplayTree<String,String> st = new SplayTree<>();
        st.put("llave","valor");

        assertEquals(1,st.size());
    }

    @Test
    void contains2() {
        SplayTree<Integer,String> st = new SplayTree<>();

        for (int i = 0; i<5700 ; i++){
            int llave = i;
            String valor = "valor"+i;
            st.put(llave,valor);
        }

        assertTrue(st.contains(5000));
    }

    @Test
    void contains1(){
        SplayTree<String,String> st = new SplayTree<>();
        st.put("llave","valor");


        st.put("llavee","valor");
        st.put("llaveee","valor");
        st.put("llaveeee","valor");
        st.put("llaveeeee","valor");
        st.put("llaveeeeee","valor");
        st.put("llaveeeeeee","valor");
        st.put("llaveeeeeee","valor");
        st.put("a","valor");
        st.put("aa","valor");
        st.put("aaa","valor");
        st.put("aaaa","valor");
        st.put("aaaaa","valor");
        st.put("aaaaaa","valor");
        st.put("aaaaaaa","valor");
        st.put("aaaaaaaa","valor");
        st.put("aaaaaaaaa","valor");
        st.put("aaaaaaaaaa","valor");
        st.put("aaaaaaaaaaa","valor");

        assertTrue(st.contains("aaaa"));
    }

    @Test
    void get() {
        SplayTree<String,String> st = new SplayTree<>();
        st.put("llave","valor");
        String prueba = st.get("llave");
        assertEquals("valor",prueba);
    }

    @Test
    void get2(){
        SplayTree<Integer,String> st = new SplayTree<>();

        for (int i = 0; i<5700 ; i++){
            int llave = i;
            String valor = "valor"+i;
            st.put(llave,valor);
        }

        String prueba = st.get(300);
        assertEquals("valor300",prueba);
    }
}