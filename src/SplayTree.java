//Código referenciado: https://bit.ly/3hsXSjD

/**
Universidad del Valle de Guatemala
Algoritmos y Estructura de Datos
Hoja de Trabajo 9
Natanael Girón (20029)
Ma. Isabel Solano (20504)
Clase SplayTree
**/
import java.lang.NullPointerException;

public class SplayTree<K extends Comparable<K>, V> implements SearchInterface<K, V> {

	private Node raiz;

	private class Node {
		private K key;
		private V value;
		private Node left, right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	@Override
	public void put(K llave, V valor) {
		//si la raiz es nula se agrega
		if (raiz == null) {
			// Si no se tiene una raiz, se agrega
			raiz = new Node(llave, valor);
			return;
		}

		//else se sigue todo el proceso
		raiz = splay(raiz, llave);

		//comparar llave brindada por la de la raiz
		int C = llave.compareTo(raiz.key);

		// insertar nuevo nodo como raiz
		if (C < 0) {
			Node nodo = new Node(llave, valor);
			nodo.left = raiz.left;
			nodo.right = raiz;
			raiz.left = null;
			raiz = nodo;
		}

		else if (C > 0) {
			Node nodo = new Node(llave, valor);
			nodo.right = raiz.right;
			nodo.left = raiz;
			raiz.right = null;
			raiz = nodo;
		}

		else {
			raiz.value = valor;
		}
	}

	@Override
	public boolean contains(K llave) {
		return get(llave) != null;
		/*
		if (get(llave) == null) {
			return false;
		} else {
			return true;
		}

		 */
	}

	@Override
	public V get(K llave) {
		raiz = splay(raiz, llave);
		int C = llave.compareTo(raiz.key);
		if (C == 0) {
			// si son iguales
			return raiz.value;
		} else {
			return null;
		}
	}

	public int size() {
		return size(raiz);
	}

	private int size(Node nodo) {
		if (nodo == null)
			return 0;
		else
			return 1 + size(nodo.left) + size(nodo.right);
	}

	public void remove(K llave) {
		if (raiz == null) {
			return;
		}

		raiz = splay(raiz, llave);

		int C = llave.compareTo(raiz.key);

		if (C == 0) {
			if (raiz.left == null) {
				raiz = raiz.right;
			} else {
				Node n = raiz.right;
				raiz = raiz.left;
				splay(raiz, llave);
				raiz.right = n;
			}
		}
	}

	private Node splay(Node nodo, K llave) {
		if (nodo == null) {
			return null;
		}

		// else, continuar
		int comparacion = llave.compareTo(nodo.key);

		// accionar dependiendo del resultado de la comparacion
		if (comparacion < 0) {
			if (nodo.left == null) {
				return nodo;
			}

			int comparacion2 = llave.compareTo(nodo.left.key);
			if (comparacion2 < 0) {
				nodo.left.left = splay(nodo.left.left, llave);
				nodo = rotacionder(nodo);
			}

			else if (comparacion2 > 0) {
				nodo.left.right = splay(nodo.left.right, llave);
				if (nodo.left.right != null) {
					nodo.left = rotacioniz(nodo.left);
				}
			}

			if (nodo.left == null) {
				return nodo;
			} else {
				return rotacionder(nodo);
			}
		}

		else if (comparacion > 0) {
			if (nodo.right == null) {
				return nodo;
			}

			int comparacion2 = llave.compareTo(nodo.right.key);
			if (comparacion2 < 0) {
				nodo.right.left = splay(nodo.right.left, llave);
				if (nodo.right.left != null) {
					nodo = rotacionder(nodo.right);
				}
			}

			else if (comparacion2 > 0) {
				nodo.right.right = splay(nodo.right.right, llave);
				nodo = rotacioniz(nodo);
			}

			if (nodo.right == null) {
				return nodo;
			} else {
				return rotacioniz(nodo);
			}
		}

		else {
			return nodo;
		}
	}

	//
	private Node rotacionder(Node nodo) {
		Node n = nodo.left;
		nodo.left = n.right;
		n.right = nodo;
		return n;
	}

	private Node rotacioniz(Node nodo) {
		Node n = nodo.right;
		nodo.right = n.left;
		n.left = nodo;
		return n;
	}
}