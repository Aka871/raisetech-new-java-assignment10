//このクラスは、org.exampleパッケージに属す
package org.example;

//java.utilパッケージのArrayListクラスを取り込め
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//パブリック設定でMainという名前のクラスを作成せよ
public class Main {

  //パブリック設定かつ静的で、戻り値がなく、String[]型の引数argsを受け取るmainという名前のメソッドを作成せよ
  public static void main(String[] args) {

    //キーがString型、値もString型のMapを作成し、変数addressMapに入れよ。HashMapクラスのインスタンスを作成し、Map型で作成した変数addressMapに入れよ
    Map<String, String> addressMap = new HashMap<>();

    //addressMapという名前のHashMapに、"井上"というキーと"hoge@gmail.com"という値を関連付けて追加せよ
    addressMap.put("井上", "hoge@gmail.com");
    addressMap.put("佐藤", "fuga@gmail.com");
    addressMap.put("田中", "aaabbbcc@yahoo.co.jp");
    addressMap.put("鈴木", "raise-tech.net");

    //String型のListを作成し、変数addressListに入れよ。
    // 変数addressMapのvaluesメソッド(要素のグループを表すインターフェースであるCollectionとして値を取得する)により、値を取得、ストリームに変換し、
    // List<String>型で作成した変数addressListに入れよ
    List<String> addressList = addressMap.values().stream()

        //addressMapの値を取得し、メールアドレスの形式に一致するものだけを抽出せよ
        .filter(s -> s.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))

        //フィルターされた要素をリストに収集し、List<String>型で作成した変数addressListに入れよ(ストリームの最終操作)
        .collect(Collectors.toList());

    //"有効なメールアドレス:"と引数addressListを連結した文字列を表示せよ
    System.out.println("有効なメールアドレス:" + addressList);
  }
}

