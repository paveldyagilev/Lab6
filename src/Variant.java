import java.io.*;

//5 Вариант. Переписать в результирующий файл слова-палиндромы
public class Variant {
    public static boolean Palindrome(String str) throws IOException{
        int len = str.length();
        for (int i = 0;  i < len/2; ++i){
            if(str.charAt(i) != str.charAt(len - i - 1)){
                return false;
            }
        }
        System.out.println(str);
        return true;
    }


    public static void main(String[]args) throws IOException{
        InputStream in = null;
        Reader file = null;
        BufferedReader bufread = null;
        OutputStream out =  null;
        Writer writer = null;
        try{
            in = new FileInputStream("C:\\Users\\6aibal\\Documents\\!Лабы\\3semestre\\AIP\\Lab 6\\in.txt");
            file = new InputStreamReader(in,"utf-8");
            bufread = new BufferedReader(file);
            File f2 = new File("C:\\Users\\6aibal\\Documents\\!Лабы\\3semestre\\AIP\\Lab 6\\out.txt");
            f2.createNewFile();
            out = new FileOutputStream(f2);
            writer = new OutputStreamWriter(out, "utf-8");
            if(f2.exists()){
                String line = " ";
                String [] words;
                while((line = bufread.readLine()) != null){
                    words = line.split(" ");
                    for(int i = 0; i < words.length; i++){
                        if(Palindrome(words[i])){
                            writer.append(words[i] + " ");
                        }
                    }
                    writer.append("\n");
                }
            }
        }
        catch (IOException e){
            System.out.println("Ошибка: "+ e);
        }
        finally {
            in.close();
            file.close();
            bufread.close();
            writer.flush();
            writer.close();
            out.close();
        }
    }
}