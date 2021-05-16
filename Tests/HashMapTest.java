import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    @Test
    void put() {
        HashMap<String,String> st = new HashMap<>();
        st.put("llavee","valor");

        assertEquals(1,st.size());
    }

    @Test
    void contains() {
        HashMap<String,String> st = new HashMap<>();
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
    void contains2(){
        HashMap<Integer,String> st = new HashMap<>();

        for (int i = 0; i<5700 ; i++){
            int llave = i;
            String valor = "valor"+i;
            st.put(llave,valor);
        }

        assertTrue(st.contains(5000));
    }

    @Test
    void get() {
        HashMap<String,String> st = new HashMap<>();
        st.put("llave","valor");
        String prueba = st.get("llave");
        assertEquals("valor",prueba);
    }

    @Test
    void get2(){
        HashMap<Integer,String> st = new HashMap<>();

        for (int i = 0; i<5700 ; i++){
            int llave = i;
            String valor = "valor"+i;
            st.put(llave,valor);
        }

        String prueba = st.get(300);
        assertEquals("valor300",prueba);
    }
}