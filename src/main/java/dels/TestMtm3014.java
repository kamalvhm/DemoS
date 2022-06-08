/*
*Copyright (c) 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014.
*
*  This is an unpublished work, is confidential and proprietary to
*  eMeter Corporation as a trade secret and is not to be used or
*  disclosed except as may be provided in an applicable eMeter Corporation
*  license agreement.
*
*  U.S. Government Rights.   The software is commercial computer software, and
*  the accompanying documentation is commercial computer software documentation.
*  The terms and conditions of eMeter Corporation's license agreement are fully
*  applicable to the Government's use and disclosure of the software and
*  documentation, and shall supersede any conflicting terms or conditions.
*  No license of any kind is granted in the case of acquisitions which contain
*  or are subject to the clauses FAR 52-227.19 COMMERCIAL COMPUTER
*  SOFTWARE-RESTRICTED RIGHTS (JUNE 1987) or DFARS 252.227-7013 RIGHTS IN
*  TECHNICAL DATA AND COMPUTER SOFTWARE (OCT 1988) or any other clause which
*  purports to grant to the Government rights greater than, or additional to
*  those, set forth in such license agreement, or which purports to impose
*  additional requirements upon eMeter.  If the license agreement fails to meet
*  the Government's stated needs or is inconsistent in any respect with federal
*  law, the Government agrees to return the software and documentation, unused,
*  to eMeter.  The Licensor/Manufacturer is eMeter Corporation,
*  4000 E. Third Ave., Fourth Floor Foster City, CA 94404 USA
*/
package dels;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections.ListUtils;
import javafx.util.Pair;

class TestMtm3014 {
  public static List<Pair<Integer, Integer>> intersectList(List<Pair<Integer, Integer>> lstRecalc,
      List<Pair<Integer, Integer>> lstPv) {
//    System.out.println(ListUtils.intersection(lstPv, lstRecalc));
    return ListUtils.intersection(lstPv, lstRecalc);
  }

  public static List<Pair<Integer, Integer>> splitList(List<Pair<Integer, Integer>> lstRecalc,
      List<Pair<Integer, Integer>> lstPv) {
//    System.out.println(ListUtils.subtract(lstPv, lstRecalc));
    return ListUtils.subtract(lstPv, lstRecalc);
  }

  public static List<Pair<Integer, Integer>> getConsequitiveSubArrays(List<Pair<Integer, Integer>> mList) {
    
    if (mList.size() == 0)
    {
        return mList;
    }
    
    int key = mList.get(0).getKey();
    int value = mList.get(0).getValue();
    List<Pair<Integer, Integer>> test = new ArrayList<Pair<Integer, Integer>>();

    for (int i = 1; i < mList.size(); i++) {
      // code block to be executed
//      System.out.println(mList.get(i));
      if (value != mList.get(i).getKey()) {
        test.add(new Pair(key, value));
        key = mList.get(i).getKey();
      }

      value = mList.get(i).getValue();

    }
    test.add(new Pair(key, value));
//    System.out.println(test);
    return test;
  }

  public static void main(String[] args) {
    List<Pair<Integer, Integer>> lstRecalc = new ArrayList<Pair<Integer, Integer>>();
    List<Pair<Integer, Integer>> lstPv = new ArrayList<Pair<Integer, Integer>>();

    // Test 1
//    lstRecalc.add(new Pair(2, 3));
//    lstRecalc.add(new Pair(3, 4));
//    lstRecalc.add(new Pair(4, 5));
//    lstRecalc.add(new Pair(5, 6));
//
//    lstPv.add(new Pair(1, 2));
//    lstPv.add(new Pair(2, 3));
//    lstPv.add(new Pair(3,4));
//    lstPv.add(new Pair(4, 5));
//    lstPv.add(new Pair(5, 6));
//    lstPv.add(new Pair(6, 7));

    // Test 2
//    lstRecalc.add(new Pair(2, 3));
//    lstRecalc.add(new Pair(3, 4));
//    lstRecalc.add(new Pair(4, 5));
//    lstRecalc.add(new Pair(5, 6));
//
//    lstPv.add(new Pair(1, 2));
//    lstPv.add(new Pair(2, 3));
//    lstPv.add(new Pair(3,4));
//    lstPv.add(new Pair(4, 5));

    // Test 3
//      lstRecalc.add(new Pair(2, 3));
//      lstRecalc.add(new Pair(3, 4));
//      lstRecalc.add(new Pair(4, 5));
//      lstRecalc.add(new Pair(5, 6));
//    
////      lstPv.add(new Pair(1, 2));
////      lstPv.add(new Pair(2, 3));
//      lstPv.add(new Pair(3, 4));
//      lstPv.add(new Pair(4, 5));
//      lstPv.add(new Pair(5, 6));
//      lstPv.add(new Pair(6, 7));

//    // Test 4
//        lstRecalc.add(new Pair(2, 3));
//        lstRecalc.add(new Pair(3, 4));
//        lstRecalc.add(new Pair(4, 5));
//        lstRecalc.add(new Pair(5, 6));
//      
//      //  lstPv.add(new Pair(1, 2));
//      //  lstPv.add(new Pair(2, 3));
//        lstPv.add(new Pair(3, 4));
//        lstPv.add(new Pair(4, 5));
////        lstPv.add(new Pair(5, 6));
////        lstPv.add(new Pair(6, 7));

//    // Test 5
//    lstRecalc.add(new Pair(2, 3));
//    lstRecalc.add(new Pair(3, 4));
//    lstRecalc.add(new Pair(4, 5));
//    lstRecalc.add(new Pair(5, 6));
//  
//  //  lstPv.add(new Pair(1, 2));
//    lstPv.add(new Pair(2, 3));
////    lstPv.add(new Pair(3, 4));
////    lstPv.add(new Pair(4, 5));
////    lstPv.add(new Pair(5, 6));
////    lstPv.add(new Pair(6, 7));

//    // Test 6
//    lstRecalc.add(new Pair(2, 3));
//    lstRecalc.add(new Pair(3, 4));
//    lstRecalc.add(new Pair(4, 5));
//    lstRecalc.add(new Pair(5, 6));
//  
//  //  lstPv.add(new Pair(1, 2));
//  //  lstPv.add(new Pair(2, 3));
////    lstPv.add(new Pair(3, 4));
//    lstPv.add(new Pair(4, 5));
//    lstPv.add(new Pair(5, 6));
////    lstPv.add(new Pair(6, 7));
    
//    // Test 7
//    lstRecalc.add(new Pair(2, 3));
//    lstRecalc.add(new Pair(3, 4));
//    lstRecalc.add(new Pair(4, 5));
//    lstRecalc.add(new Pair(5, 6));
//  
//    lstPv.add(new Pair(1, 2));
//    lstPv.add(new Pair(2, 3));
////    lstPv.add(new Pair(3, 4));
//    lstPv.add(new Pair(4, 5));
//    lstPv.add(new Pair(5, 6));
//    lstPv.add(new Pair(6, 7));

//    // Test 8
//    lstRecalc.add(new Pair(2, 3));
//    lstRecalc.add(new Pair(3, 4));
//    lstRecalc.add(new Pair(4, 5));
//    lstRecalc.add(new Pair(5, 6));
//    lstRecalc.add(new Pair(6, 7));
//    lstRecalc.add(new Pair(7, 8));    
//  
//    lstPv.add(new Pair(1, 2));
//    lstPv.add(new Pair(2, 3));
////    lstPv.add(new Pair(3, 4));
//    lstPv.add(new Pair(4, 5));
//    lstPv.add(new Pair(5, 6));
////    lstPv.add(new Pair(6, 7));
//    lstPv.add(new Pair(7, 8));
//    lstPv.add(new Pair(8, 9));

  // Test 9
//  lstRecalc.add(new Pair(2, 3));
//  lstRecalc.add(new Pair(3, 4));
//  lstRecalc.add(new Pair(4, 5));
//  lstRecalc.add(new Pair(5, 6));
//
//  lstPv.add(new Pair(1, 2));
//  lstPv.add(new Pair(2, 3));
////  lstPv.add(new Pair(3, 4));
//  lstPv.add(new Pair(4, 5));
////  lstPv.add(new Pair(5, 6));
////  lstPv.add(new Pair(6, 7));
////  lstPv.add(new Pair(7, 8));
////  lstPv.add(new Pair(8, 9));

  // Test 10
  lstRecalc.add(new Pair(2, 3));
  lstRecalc.add(new Pair(3, 4));
  lstRecalc.add(new Pair(4, 5));
  lstRecalc.add(new Pair(5, 6));

  lstPv.add(new Pair(1, 2));
  lstPv.add(new Pair(2, 3));
  lstPv.add(new Pair(3, 4));
  lstPv.add(new Pair(4, 5));
  lstPv.add(new Pair(5, 6));
  lstPv.add(new Pair(6, 7));
//  lstPv.add(new Pair(7, 8));
//  lstPv.add(new Pair(8, 9));


    // Recalcs
    System.out.println("RecalcFiltered "+getConsequitiveSubArrays(splitList(lstPv, lstRecalc)));
    System.out.println("Recalc Done "+getConsequitiveSubArrays(intersectList(lstRecalc, lstPv)));

    //FpC's
    System.out.println("FPCs "+getConsequitiveSubArrays(lstPv));
  }
}
