package com.test.common.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class Printer {

  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

  private static final String ZERO = "0";

  private static final String EMPTY_STRING = "";

  public String checkLength(int size) {

    return StringUtils.rightPad(EMPTY_STRING, size);
  }

  public String addRightEmpty(String str, int size) {

    return StringUtils.rightPad(str, size, EMPTY_STRING);
  }

  public String addLeftZero(String str, int size) {

    return StringUtils.leftPad(str, size, ZERO);
  }

  public String getStr(String str, int size) {
    return str.substring(0, Math.min(str.length(), size));
  }

  public String checkLength(String str, int size) {

    return Optional.ofNullable(str)
        .map(String::trim)
        .map(e -> getStr(e, size))
        .map(e -> addRightEmpty(e, size))
        .orElseGet(() -> checkLength(size));
  }

  public String checkLength(Long l, int size) {

    return Optional.ofNullable(l)
        .map(Object::toString)
        .map(String::trim)
        .map(e -> getStr(e, size))
        .map(e -> addLeftZero(e, size))
        .orElseGet(() -> checkLength(size));
  }

  public String checkLength(LocalDate date, int size) {
    return Optional.ofNullable(date).map(formatter::format).orElseGet(() -> checkLength(size));
  }

  public String checkLength(Integer l, int size) {
    return Optional.ofNullable(l)
        .map(Object::toString)
        .map(String::trim)
        .map(e -> getStr(e, size))
        .map(e -> addLeftZero(e, size))
        .orElseGet(() -> checkLength(size));
  }
}
