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

    //課題1:Listにランダムな文字列を30個入れる
    //String型のListを作成し、変数randomStringsに入れよ。Arrays.asListメソッドを使用し、30個のランダムな文字列を順番に入れたListを作成し、
    // List<String>型で作成した変数randomStringsに入れよ
    List<String> randomStrings = new ArrayList<>(Arrays.asList(
        "山田太郎42歳", "住所: 東京都千代田区1-2-3", "電話: 090-1234-5678", "価格: ¥5000", "製品コード: ABC123XZ",
        "2024年のオリンピック", "郵便番号: 123-4567", "2人用の席", "12時30分に集合", "高さ: 170cm", "重量: 70kg",
        "速度: 60km/h", "来週の月曜日", "3個入り", "合計金額: ¥450", "予約番号: 987654", "郵便番号: 987-6543",
        "誕生日: 1990年7月15日", "好きな数字: 7", "ID: user123", "週末に予定", "5つ星評価", "出発時刻: 14:55",
        "到着時刻: 17:30", "面積: 45㎡", "新宿区四谷3-4-5", "寿司20貫", "カレー2杯目", "ラーメン1杯半", "注文番号: ORD5678"
    ));

    //変数randomStringsの要素を先頭から順に取り出し、各要素をString型のstrに入れよ
    for (String str : randomStrings) {
      //変数strを表示せよ
      System.out.println(str);
    }

    //課題2:数字だけを抜き出す正規表現(連続した数字は1つのものとする)を行う
    //正規表現"\\d+"を使って数字だけを抜き出すための正規表現を作成し、
    //正規表現の文字列をPatternクラスのcompileメソッド(正規表現をコンパイルして効率的に使用できる形式に変換する)に渡せ
    //そして、この正規表現をコンパイルし、Pattern型で作成した変数numberPatternに入れよ (PatternクラスのインスタンスnumberPatternを作成)
    Pattern numberPattern = Pattern.compile("\\d+");

    //改行し、"数字だけを抜き出す:"という文字列を表示せよ
    System.out.println("\n数字だけを抜き出す:");

    //変数randomStringsの要素を先頭から順に取り出し、各要素をString型の変数strに入れよ
    for (String str : randomStrings) {

      //変数strに変数numberPatternのmatcherメソッド(指定された文字列に対して正規表現パターンを適用し、
      //マッチング結果を管理するMatcherオブジェクトを生成する)を適用し、Matcher型で作成した変数digitMatcherに入れよ
      Matcher digitMatcher = numberPattern.matcher(str);

      //変数digitMatcherのfindメソッド(入力文字列の中で正規表現に一致する部分を順に探し、一致部分が見つかった場合にtrueを返す)を呼び出し、
      //マッチする部分がある限り繰り返せ
      while (digitMatcher.find()) {

        //変数digitMatcherのgroupメソッド(findメソッドで見つかった一致部分の文字列を返す)を呼び出し、マッチした部分を表示せよ
        System.out.println(digitMatcher.group());
      }
    }

    //課題3:文字だけを抜き出す正規表現を行う
    //正規表現"\\D+"を使って文字だけを抜き出すための正規表現を作成し、
    //正規表現の文字列をPatternクラスのcompileメソッド(正規表現をコンパイルして効率的に使用できる形式に変換する)に渡せ
    //そして、この正規表現をコンパイルし、Pattern型で作成した変数charPatterに入れよ (PatternクラスのインスタンスcharPatterを作成)
    Pattern charPattern = Pattern.compile("\\D+");

    //改行し、"文字だけを抜き出す:"という文字列を表示せよ
    System.out.println("\n文字だけを抜き出す:");

    //変数randomStringsの要素を先頭から順に取り出し、各要素をString型の変数strに入れよ
    for (String str : randomStrings) {

      //変数strに変数charPatternのmatcherメソッド(指定された文字列に対して正規表現パターンを適用し、
      //マッチング結果を管理するMatcherオブジェクトを生成する)を適用し、Matcher型で作成した変数letterMatcherに入れよ
      Matcher letterMatcher = charPattern.matcher(str);

      //変数letterMatcherのfindメソッド(入力文字列の中で正規表現に一致する部分を順に探し、一致部分が見つかった場合にtrueを返す)を呼び出し、
      //マッチする部分がある限り繰り返せ
      while (letterMatcher.find()) {

        //変数letterMatcherのgroupメソッド(findメソッドで見つかった一致部分の文字列を返す)を呼び出し、
        //文字列の両端にあるすべての空白文字を削除、マッチした部分を表示せよ
        System.out.println(letterMatcher.group().trim());
      }
    }

    // 課題4: 英数字の大文字だけを抜き出す正規表現を行う
    //正規表現"[A-Z]+"を使って英数字の大文字だけを抜き出すための正規表現を作成し、
    //正規表現の文字列をPatternクラスのcompileメソッド(正規表現をコンパイルして効率的に使用できる形式に変換する)に渡せ
    //そして、この正規表現をコンパイルし、Pattern型で作成した変数upperCasePatternに入れよ (PatternクラスのインスタンスupperCasePatternを作成)
    Pattern upperCasePattern = Pattern.compile("[A-Z]+");

    //改行し、"英数字の大文字だけを抜き出す:"という文字列を表示せよ
    System.out.println("\n英数字の大文字だけを抜き出す:");

    //変数randomStringsの要素を先頭から順に取り出し、各要素をString型の変数strに入れよ
    for (String str : randomStrings) {

      //変数strに変数upperCasePatternのmatcherメソッド(指定された文字列に対して正規表現パターンを適用し、
      //マッチング結果を管理するMatcherオブジェクトを生成する)を適用し、Matcher型で作成した変数upperCaseMatcherに入れよ
      Matcher upperCaseMatcher = upperCasePattern.matcher(str);

      //変数upperCaseMatcherのfindメソッド(入力文字列の中で正規表現に一致する部分を順に探し、一致部分が見つかった場合にtrueを返す)を呼び出し、
      //マッチする部分がある限り繰り返せ
      while (upperCaseMatcher.find()) {

        //変数upperCaseMatcherのgroupメソッド(findメソッドで見つかった一致部分の文字列を返す)を呼び出し、マッチした部分を表示せよ
        System.out.println(upperCaseMatcher.group());
      }
    }

    // 課題5: 漢字、平仮名、カタカナなどの日本語にマッチする正規表現を行う
    //正規表現"[\p{IsHan}\p{IsHiragana}\p{IsKatakana}ー]+"を使って漢字、平仮名、カタカナなどの日本語にマッチするための正規表現を作成し、
    //正規表現の文字列をPatternクラスのcompileメソッド(正規表現をコンパイルして効率的に使用できる形式に変換する)に渡せ
    //そして、この正規表現をコンパイルし、Pattern型で作成した変数japanesePatternに入れよ (PatternクラスのインスタンスjapanesePatternを作成)
    Pattern japanesePattern = Pattern.compile("[\\p{IsHan}\\p{IsHiragana}\\p{IsKatakana}ー]+");

    //改行し、"漢字、平仮名、カタカナなどの日本語にマッチする:"という文字列を表示せよ
    System.out.println("\n漢字、平仮名、カタカナなどの日本語にマッチする:");

    //変数randomStringsの要素を先頭から順に取り出し、各要素をString型の変数strに入れよ
    for (String str : randomStrings) {

      //変数strに変数japanesePatternのmatcherメソッド(指定された文字列に対して正規表現パターンを適用し、
      //マッチング結果を管理するMatcherオブジェクトを生成する)を適用し、Matcher型で作成した変数japaneseMatcherに入れよ
      Matcher japaneseMatcher = japanesePattern.matcher(str);

      //変数japaneseMatcherのfindメソッド(入力文字列の中で正規表現に一致する部分を順に探し、一致部分が見つかった場合にtrueを返す)を呼び出し、
      //マッチする部分がある限り繰り返せ
      while (japaneseMatcher.find()) {

        //変数japaneseMatcherのgroupメソッド(findメソッドで見つかった一致部分の文字列を返す)を呼び出し、マッチした部分を表示せよ
        System.out.println(japaneseMatcher.group());
      }
    }

    // 課題6: 英数字以外の文字を抜き出す正規表現を行う
    //正規表現"[^a-zA-Z0-9]+"を使って英数字以外の文字を抜き出すための正規表現を作成し、
    //正規表現の文字列をPatternクラスのcompileメソッド(正規表現をコンパイルして効率的に使用できる形式に変換する)に渡せ
    //そして、この正規表現をコンパイルし、Pattern型で作成した変数nonAlphanumericPatternに入れよ (PatternクラスのインスタンスnonAlphanumericPatternを作成)
    Pattern nonAlphanumericPattern = Pattern.compile("[^a-zA-Z0-9]+");

    //改行し、"英数字以外の文字を抜き出す:"という文字列を表示せよ
    System.out.println("\n英数字以外の文字を抜き出す:");

    //変数randomStringsの要素を先頭から順に取り出し、各要素をString型の変数strに入れよ
    for (String str : randomStrings) {

      //変数strに変数nonAlphanumericPatternのmatcherメソッド(指定された文字列に対して正規表現パターンを適用し、
      //マッチング結果を管理するMatcherオブジェクトを生成する)を適用し、Matcher型で作成した変数nonAlphanumericMatcherに入れよ
      Matcher nonAlphanumericMatcher = nonAlphanumericPattern.matcher(str);

      //変数nonAlphanumericMatcherのfindメソッド(入力文字列の中で正規表現に一致する部分を順に探し、一致部分が見つかった場合にtrueを返す)を呼び出し、
      //マッチする部分がある限り繰り返せ
      while (nonAlphanumericMatcher.find()) {

        //変数nonAlphanumericMatcherのgroupメソッド(findメソッドで見つかった一致部分の文字列を返す)を呼び出し、
        // 文字列の両端にあるすべての空白文字を削除、マッチした部分を表示せよ
        System.out.println(nonAlphanumericMatcher.group().trim());
      }
    }
  }
}

