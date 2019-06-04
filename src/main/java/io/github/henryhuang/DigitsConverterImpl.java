package io.github.henryhuang;

import io.github.henryhuang.digitsmapper.DigitsMapper;
import io.github.henryhuang.digitsmapper.TelephoneButtonsDigitsMapper;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Digits converter
 *
 * Created by Henry Huang on 2019/6/4.
 */
public class DigitsConverterImpl implements DigitsConverter {

  private DigitsMapper digitsMapper;

  public DigitsConverterImpl() {
    this(null);
  }

  public DigitsConverterImpl(DigitsMapper digitsMapper) {
    if (digitsMapper == null) {
      this.digitsMapper = new TelephoneButtonsDigitsMapper();
    } else {
      this.digitsMapper = digitsMapper;
    }
  }

  @Override
  public String convert(int[] digits) {

    if (this.digitsMapper == null) {
      throw new InvalidParameterException("Please provide digits mapper");
    }

    Set<String> convertedSet = new LinkedHashSet<>();

    Map<Integer, String> buttonContentMap = new HashMap<>();
    for (int digit : digits) {
      String digitString = digitsMapper.map(digit);
      if (digitString.length() > 0) {
        buttonContentMap.put(digit, digitString);
      }
    }

    List<Integer> actualDigits = new ArrayList<>(buttonContentMap.keySet());
    int convertedLength = actualDigits.size();

    Queue<String> tempStored = new LinkedList<>();
    tempStored.add("");

    while (!tempStored.isEmpty()) {

      String temp = tempStored.remove();

      int tempLength = temp.length();
      if (tempLength == convertedLength) {
        convertedSet.add(temp);
      } else {
        String buttonContent = buttonContentMap.get(actualDigits.get(tempLength));
        for (int i = 0; i < buttonContent.length(); i++) {
          tempStored.add(temp + buttonContent.charAt(i));
        }
      }

    }

    return join(convertedSet, " ");
  }

  private String join(Set<String> set, String separator) {
    StringBuilder ret = new StringBuilder();

    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
      ret.append(iterator.next());
      if (iterator.hasNext()) {
        ret.append(separator);
      }
    }

    return ret.toString();
  }

}
