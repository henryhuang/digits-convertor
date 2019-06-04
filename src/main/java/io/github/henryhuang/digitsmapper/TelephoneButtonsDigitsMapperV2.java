package io.github.henryhuang.digitsmapper;

/**
 * Created by Henry Huang on 2019/6/5.
 */
public class TelephoneButtonsDigitsMapperV2 extends TelephoneButtonsDigitsMapper {

  @Override
  public String map(Integer digit) {
    if (digit <= 9) {
      return super.map(digit);
    } else {
      StringBuilder ret = new StringBuilder();
      String digitString = String.valueOf(digit);
      for (int i = 0; i < digitString.length(); i++) {
        ret.append(super.map(Integer.valueOf(digitString.charAt(i) + "")));
      }
      return ret.toString();
    }
  }

}
