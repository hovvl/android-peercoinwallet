/*
 * Copyright 2013 Megion Research & Development GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mrd.bitlib.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Utility for turning an amount of peers into a user friendly string. 1
 * peer == 0.000000001 PPC
 */
 
/*    Original Code:
public class CoinUtil {

   private static final BigDecimal BTC_IN_SATOSHIS = new BigDecimal(100000000);
   private static final BigDecimal mBTC_IN_SATOSHIS = new BigDecimal(100000);
   private static final BigDecimal uBTC_IN_SATOSHIS = new BigDecimal(100);
   private static final DecimalFormat COIN_FORMAT;

   static {
      COIN_FORMAT = new DecimalFormat();
      COIN_FORMAT.setGroupingSize(3);
      COIN_FORMAT.setGroupingUsed(true);
      COIN_FORMAT.setMaximumFractionDigits(8);
      DecimalFormatSymbols symbols = COIN_FORMAT.getDecimalFormatSymbols();
      symbols.setDecimalSeparator('.');
      symbols.setGroupingSeparator(' ');
      COIN_FORMAT.setDecimalFormatSymbols(symbols);
   }

   public enum Denomination {
      BTC(8, "BTC", "BTC", BTC_IN_SATOSHIS), mBTC(5, "mBTC", "mBTC", mBTC_IN_SATOSHIS), uBTC(2, "uBTC", "\u00B5BTC",
            uBTC_IN_SATOSHIS);

      private final int _decimalPlaces;
      private final String _asciiString;
      private final String _unicodeString;
      private final BigDecimal _oneUnitInSatoshis;

      private Denomination(int decimalPlaces, String asciiString, String unicodeString, BigDecimal oneUnitInSatoshis) {
         _decimalPlaces = decimalPlaces;
         _asciiString = asciiString;
         _unicodeString = unicodeString;
         _oneUnitInSatoshis = oneUnitInSatoshis;
      }

      public int getDecimalPlaces() {
         return _decimalPlaces;
      }

      public String getAsciiName() {
         return _asciiString;
      }

      public String getUnicodeName() {
         return _unicodeString;
      }

      public BigDecimal getOneUnitInSatoshis() {
         return _oneUnitInSatoshis;
      }

      @Override
      public String toString() {
         return _asciiString;
      }

      public static Denomination fromString(String string) {
         if (string == null) {
            return BTC;
         }
         if (string.equals("BTC")) {
            return BTC;
         } else if (string.equals("mBTC")) {
            return mBTC;
         } else if (string.equals("uBTC")) {
            return uBTC;
         } else {
            return BTC;
         }
      }

   };
*/

public class CoinUtil {

   private static final BigDecimal PPC_IN_PEERS = new BigDecimal(100000000);
   private static final BigDecimal mPPC_IN_PEERSS = new BigDecimal(100000);
   private static final BigDecimal uPPC_IN_PEERS = new BigDecimal(100);
   private static final DecimalFormat COIN_FORMAT;

   static {
      COIN_FORMAT = new DecimalFormat();
      COIN_FORMAT.setGroupingSize(3);
      COIN_FORMAT.setGroupingUsed(true);
      COIN_FORMAT.setMaximumFractionDigits(8);
      DecimalFormatSymbols symbols = COIN_FORMAT.getDecimalFormatSymbols();
      symbols.setDecimalSeparator('.');
      symbols.setGroupingSeparator(' ');
      COIN_FORMAT.setDecimalFormatSymbols(symbols);
   }

   public enum Denomination {
      PPC(8, "PPC", "PPC", PPC_IN_PEERS), mPPC(5, "mPPC", "mPPC", mPPC_IN_PEERS), uPPC(2, "uPPC", "\u00B5PPC",
            uPPC_IN_PEERS);

      private final int _decimalPlaces;
      private final String _asciiString;
      private final String _unicodeString;
      private final BigDecimal _oneUnitInPeers;

      private Denomination(int decimalPlaces, String asciiString, String unicodeString, BigDecimal oneUnitInPeers) {
         _decimalPlaces = decimalPlaces;
         _asciiString = asciiString;
         _unicodeString = unicodeString;
         _oneUnitInPeers = oneUnitInPeers;
      }

      public int getDecimalPlaces() {
         return _decimalPlaces;
      }

      public String getAsciiName() {
         return _asciiString;
      }

      public String getUnicodeName() {
         return _unicodeString;
      }

      public BigDecimal getOneUnitInPeers() {
         return _oneUnitInPeers;
      }

      @Override
      public String toString() {
         return _asciiString;
      }

      public static Denomination fromString(String string) {
         if (string == null) {
            return PPC;
         }
         if (string.equals("PPC")) {
            return PPC;
         } else if (string.equals("mPPC")) {
            return mPPC;
         } else if (string.equals("uPPC")) {
            return uPPC;
         } else {
            return PPC;
         }
      }

   };

   /**
    * Number of peers in a Peercoin.
    */
   public static final BigInteger PPC = new BigInteger("100000000", 10);

   /**
    * Get the given value in peers as a string on the form "10.12345"
    * denominated in PPC.
    * <p>
    * This method only returns necessary decimal points to tell the exact value.
    * If you wish to display all digits use
    * {@link CoinUtil#fullValueString(long)}
    * 
    * @param value
    *           The number of peers
    * @param withThousandSeparator
    *           Use ' ' as the 1000 grouping separator in the output 
    * @return The given value in peers as a string on the form "10.12345".
    */
/*     Original Code:
   public static String valueString(long value, boolean withThousandSeparator) {
      return valueString(value, Denomination.BTC, withThousandSeparator);
   }
*/

   public static String valueString(long value, boolean withThousandSeparator) {
      return valueString(value, Denomination.PPC, withThousandSeparator);
   }
   
   /**
    * Get the given value in peers as a string on the form "10.12345" using
    * the specified denomination.
    * <p>
    * This method only returns necessary decimal points to tell the exact value.
    * If you wish to display all digits use
    * {@link CoinUtil#fullValueString(long, Denomination)}
    * 
    * @param value
    *           The number of peers
    * @param denomination
    *           The denomination to use
    * @param withThousandSeparator
    *           Use ' ' as the 1000 grouping separator in the output 
    * @return The given value in peers as a string on the form "10.12345".
    */
/*

   public static String valueString(long value, Denomination denomination, boolean withThousandSeparator) {
      BigDecimal d = BigDecimal.valueOf(value);
      d = d.divide(denomination.getOneUnitInSatoshis());
      if (!withThousandSeparator) {
         return d.toPlainString();
      } else {
         return COIN_FORMAT.format(d);
      }
   }
*/

   public static String valueString(long value, Denomination denomination, boolean withThousandSeparator) {
      BigDecimal d = BigDecimal.valueOf(value);
      d = d.divide(denomination.getOneUnitInPeers());
      if (!withThousandSeparator) {
         return d.toPlainString();
      } else {
         return COIN_FORMAT.format(d);
      }
   }
   
   /**
    * Get the given value in peers as a string on the form "10.12345000"
    * denominated in PPC.
    * <p>
    * This method always returns a string with 8 decimal points. If you only
    * wish to have the necessary digits use {@link CoinUtil#valueString(long)}
    * 
    * @param value
    *           The number of peers
    * @return The given value in peers as a string on the form "10.12345000".
    */
/*
   public static String fullValueString(long value) {
      return fullValueString(value, Denomination.BTC);
   }
*/

   public static String fullValueString(long value) {
      return fullValueString(value, Denomination.PPC);
   }

   /**
    * Get the given value in peers as a string on the form "10.12345000"
    * using the specified denomination.
    * <p>
    * This method always returns a string with all decimal points. If you only
    * wish to have the necessary digits use
    * {@link CoinUtil#valueString(long, Denomination)}
    * 
    * @param value
    *           The number of peers
    * @param denomination
    *           The denomination to use
    * @return The given value in peers as a string on the form "10.12345000".
    */
    
   public static String fullValueString(long value, Denomination denomination) {
      BigDecimal d = BigDecimal.valueOf(value);
      d = d.movePointLeft(denomination.getDecimalPlaces());
      return d.toPlainString();
   }

}
