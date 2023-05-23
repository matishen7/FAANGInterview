package Mentorship;

public class MyArrayListProgram {
    public static void main(String[] args) throws Exception {
        CustomArrayList my_array_list = new CustomArrayList();
        my_array_list.set(0, 1);
        System.out.println(my_array_list.get(0));
        my_array_list.add(2);
        System.out.println(my_array_list.get(0));
        System.out.println(my_array_list.get(1));
        my_array_list.remove(1); //
        System.out.println(my_array_list.get(0));
        System.out.println(my_array_list.size());
        my_array_list.add(2);
        my_array_list.add(2);
        my_array_list.add(2);
        System.out.println(my_array_list.size());
    }

    private static class CustomArrayList {
        private int[] elements;
        int default_size = 1;

        public CustomArrayList() {
            elements = new int[default_size];
        }

        public void add(int value) {
            int[] newElements = new int[this.elements.length + 1];
            newElements = CopyValues(elements, newElements, -1);
            newElements[newElements.length - 1] = value;
            this.elements = new int[newElements.length];
            elements = CopyValues(newElements, elements, -1);
        }

        public void remove(int index){
            int[] newElements = new int[this.elements.length - 1];
            newElements = CopyValues(elements, newElements, index);
            this.elements = new int[newElements.length];
            elements = CopyValues(newElements, elements, -1);
        }

        private int[] CopyValues(int[] source, int[] target, int skipIndex) {
            for (int i = 0; i < source.length; i++) {
                if (skipIndex == i) continue;
                target[i] = source[i];
            }
            return target;
        }

        private int size(){
            return elements.length;
        }

        private boolean IsEmpty(){
            return elements.length == 0;
        }

        public void set(int index, int value) throws Exception {
            if (elements.length > index)
                elements[index] = value;
            else throw new Exception("Index out of bound");
        }

        public int get(int index) throws Exception {
            if (elements.length > index) return elements[index];
            else throw new Exception("Index out of bound");
        }


    }
}
