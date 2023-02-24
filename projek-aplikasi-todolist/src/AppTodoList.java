import java.util.Scanner;

class AppTodoList {

    public static String[] data = new String[10];

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    public static void showTodoList() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                break;
            }

            var no = i + 1;
            System.out.println(no + ". " + data[i]);
        }
    }

    public static void testShowTodoList() {
        data[0] = "Satu";
        data[1] = "Dua";
        data[2] = "Tiga";

        showTodoList();
    }

    public static void addTodoList(String activity) {
        var isFull = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            var temp = data;
            data = new String[data.length * 2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }

        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = activity;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 30; i++) {
            addTodoList("Data ke " + i);
        }

        showTodoList();
    }

    public static boolean deleteTodoList(int angka) {
        if ((angka - 1 >= data.length)) {
            return false;
        } else if (data[angka - 1] == null) {
            return false;
        } else {
            for (int i = (angka - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }

    public static void testDeleteTodoList() {
        for (int i = 0; i < data.length; i++) {
            addTodoList("Data " + (i + 1));
        }

        deleteTodoList(9);
        showTodoList();

    }

    public static String inputUser(String info) {
        System.out.print(info + " : ");
        var inputData = scanner.nextLine();
        return inputData;
    }

    public static void testInputUser() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList(inputUser("Tambah Data"));
        showTodoList();
    }

    public static boolean viewShowTodoList() {
        while (true) {
            System.out.println("-== Todo List ==-");
            if (data[0] == null) {
                System.out.println("Data Kosong");
            } else {
                showTodoList();
            }

            System.out.println("\n-== Menu ==-");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Keluar");

            var pilih = inputUser("Pilih [x keluar]");
            switch (pilih) {
                case "1":
                    viewAddTodoList();
                    break;
                case "2":
                    viewDeleteTodoList();
                    break;
                case "3":
                    System.out.println("Terima Kasih");
                    return false;
                default:
                    System.out.println("Nomor yang anda masukkan salah !");
            }
        }
    }

    public static void viewAddTodoList() {
        var inputTambah = inputUser("Tambah Data");
        addTodoList(inputTambah);
    }

    public static void viewDeleteTodoList() {
        var inputDelete = inputUser("Nomor");
        if (inputDelete.equals("x")) {
            // Batal
        } else {
            boolean hapus = deleteTodoList(Integer.valueOf(inputDelete));
            if (!hapus) {
                System.out.println("Gagal Meghapus Data");
            }
        }
    }
}