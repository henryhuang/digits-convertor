package io.github.henryhuang.digitsmapper;

import java.security.InvalidParameterException;

/**
 * Created by Henry Huang on 2019/6/5.
 */
public class TelephoneButtonsDigitsMapper implements DigitsMapper {

  private static final String[] PHONE_TABLE = new String[]{
      "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
  };

  @Override
  public String map(Integer digit) {
    if (digit < 0 || digit > 9) {
      throw new InvalidParameterException("Digit cannot greater than 9");
    }
    return PHONE_TABLE[digit];
  }

}
