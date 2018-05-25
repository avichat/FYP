
package transactionsystem;

import re.structure.*;
import java.util.HashMap;




public aspect Properties {


//// the code for EXPECT: (((!(USER_login))* ; ADMIN_initialise) ; (?)*)
//static String monitorState5db9742 = null;
//static void init5db9742(){ 
// monitorState5db9742 = "S_{[66, 67, 68, 70, 72, 74, 79, 82]}"; }
//
//
//
//static boolean checkMonitor5db9742(String state) { return state.equals(monitorState5db9742); }
//
//static boolean setMonitor5db9742(String state) { 
//  monitorState5db9742=state; 
//  return true; }
//
//before (): call(* *.USER_login(..)){ 
// if (1==0) {}
//   else if ( checkMonitor5db9742("N_{[67, 68, 69, 70, 71, 73, 74, 75, 76, 77, 80, 81]}")
// && (setMonitor5db9742("N_{[76, 77, 78, 80]}"))) {}
//
//   else if ( checkMonitor5db9742("N_{[76, 77, 78, 80]}")
// && (setMonitor5db9742("N_{[76, 77, 78, 80]}"))) {}
//
//   else if ( checkMonitor5db9742("N_{[67, 68, 69, 70, 71, 73, 74, 75, 76, 77, 78, 80, 81]}")
// && (setMonitor5db9742("N_{[76, 77, 78, 80]}"))) {}
//
//   else if ( checkMonitor5db9742("S_{[66, 67, 68, 70, 72, 74, 79, 82]}")
// && (setMonitor5db9742("F_83"))) {
// Verification.fail(" FAILED ON REGEXP EXPECT (((!(USER_login))* ; ADMIN_initialise) ; (?)*)");}
//
//   else if ( checkMonitor5db9742("F_83")
// && (setMonitor5db9742("F_83"))) {
// Verification.fail(" FAILED ON REGEXP EXPECT (((!(USER_login))* ; ADMIN_initialise) ; (?)*)");}
//}
//
//
//before (): call(* *.ADMIN_initialise(..)){ 
// if (1==0) {}
//   else if ( checkMonitor5db9742("F_83")
// && (setMonitor5db9742("F_83"))) {
// Verification.fail(" FAILED ON REGEXP EXPECT (((!(USER_login))* ; ADMIN_initialise) ; (?)*)");}
//
//   else if ( checkMonitor5db9742("S_{[66, 67, 68, 70, 72, 74, 79, 82]}")
// && (setMonitor5db9742("N_{[67, 68, 69, 70, 71, 73, 74, 75, 76, 77, 80, 81]}"))) {}
//
//   else if ( checkMonitor5db9742("N_{[67, 68, 69, 70, 71, 73, 74, 75, 76, 77, 80, 81]}")
// && (setMonitor5db9742("N_{[67, 68, 69, 70, 71, 73, 74, 75, 76, 77, 78, 80, 81]}"))) {}
//
//   else if ( checkMonitor5db9742("N_{[76, 77, 78, 80]}")
// && (setMonitor5db9742("N_{[76, 77, 78, 80]}"))) {}
//
//   else if ( checkMonitor5db9742("N_{[67, 68, 69, 70, 71, 73, 74, 75, 76, 77, 78, 80, 81]}")
// && (setMonitor5db9742("N_{[67, 68, 69, 70, 71, 73, 74, 75, 76, 77, 78, 80, 81]}"))) {}
//}
//
//
//
//
//// the code for UNEXPECT: ((!(ADMIN_initialise))* ; USER_login)
//static String monitorStated06d69c = null;
//static void initd06d69c(){ 
// monitorStated06d69c = "S_{[84, 85, 86, 88, 90, 92, 93]}"; }
//
//
//
//static boolean checkMonitord06d69c(String state) { return state.equals(monitorStated06d69c); }
//
//static boolean setMonitord06d69c(String state) { 
//  monitorStated06d69c=state; 
//  return true; }
//
//before (): call(* *.USER_login(..)){ 
// if (1==0) {}
//   else if ( checkMonitord06d69c("S_{[84, 85, 86, 88, 90, 92, 93]}")
// && (setMonitord06d69c("F_{[85, 86, 87, 88, 89, 91, 92]}"))) {
// Verification.fail(" FAILED ON REGEXP UNEXPECT ((!(ADMIN_initialise))* ; USER_login)");}
//
//   else if ( checkMonitord06d69c("F_{[85, 86, 87, 88, 89, 91, 92]}")
// && (setMonitord06d69c("F_{[85, 86, 87, 88, 89, 91, 92]}"))) {
// Verification.fail(" FAILED ON REGEXP UNEXPECT ((!(ADMIN_initialise))* ; USER_login)");}
//
//   else if ( checkMonitord06d69c("N_94")
// && (setMonitord06d69c("N_94"))) {}
//}
//
//
//before (): call(* *.ADMIN_initialise(..)){ 
// if (1==0) {}
//   else if ( checkMonitord06d69c("N_94")
// && (setMonitord06d69c("N_94"))) {}
//
//   else if ( checkMonitord06d69c("S_{[84, 85, 86, 88, 90, 92, 93]}")
// && (setMonitord06d69c("N_94"))) {}
//
//   else if ( checkMonitord06d69c("F_{[85, 86, 87, 88, 89, 91, 92]}")
// && (setMonitord06d69c("N_94"))) {}
//}
//
//
//
//
//// the code for UNEXPECT: ((((!(openSession))* ; (((openSession ; (!(closeSession))*) ; closeSession))*) ; (!(openSession))*) ; log)
//static HashMap<UserSession, String> monitors852e922 = null;
//static void init852e922(){ monitors852e922= new HashMap<UserSession, String>(); }
//
//
//
//static boolean checkMonitor852e922(UserSession target, String state) { 
// if (monitors852e922.containsKey(target))
//  return state.equals(monitors852e922.get(target));
// else {
//  monitors852e922.put(target, "S_{[100, 101, 107, 112, 115, 116, 117, 118, 119, 120, 122, 123, 124, 125, 127, 129, 130, 95, 96, 97, 99]}");
//  return state.equals("S_{[100, 101, 107, 112, 115, 116, 117, 118, 119, 120, 122, 123, 124, 125, 127, 129, 130, 95, 96, 97, 99]}"); }
// }
//
//static boolean setMonitor852e922(UserSession target, String state) { 
// if (monitors852e922.containsKey(target))
// { monitors852e922.put(target,state);
//   return true; 
// }
// else {
//  return false; }
// }
//
//before (UserSession u): call(* *.log(..)) &&
//    target(u){ 
// if (1==0) {}
//   else if ( checkMonitor852e922(u, "S_{[100, 101, 107, 112, 115, 116, 117, 118, 119, 120, 122, 123, 124, 125, 127, 129, 130, 95, 96, 97, 99]}")
// && (setMonitor852e922(u, "F_{[100, 101, 107, 112, 116, 117, 118, 119, 120, 121, 123, 124, 125, 126, 128, 129, 96, 97, 98, 99]}"))) {
// Verification.fail(" FAILED ON REGEXP UNEXPECT ((((!(openSession))* ; (((openSession ; (!(closeSession))*) ; closeSession))*) ; (!(openSession))*) ; log)");}
//
//   else if ( checkMonitor852e922(u, "F_{[100, 101, 107, 112, 116, 117, 118, 119, 120, 121, 123, 124, 125, 126, 128, 129, 96, 97, 98, 99]}")
// && (setMonitor852e922(u, "F_{[100, 101, 107, 112, 116, 117, 118, 119, 120, 121, 123, 124, 125, 126, 128, 129, 96, 97, 98, 99]}"))) {
// Verification.fail(" FAILED ON REGEXP UNEXPECT ((((!(openSession))* ; (((openSession ; (!(closeSession))*) ; closeSession))*) ; (!(openSession))*) ; log)");}
//
//   else if ( checkMonitor852e922(u, "N_{[102, 103, 104, 105, 108, 109, 110, 114]}")
// && (setMonitor852e922(u, "N_{[104, 105, 106, 108, 110, 114]}"))) {}
//
//   else if ( checkMonitor852e922(u, "N_{[100, 101, 107, 112, 116, 117, 118, 119, 120, 121, 123, 124, 125, 129, 96, 97, 98, 99]}")
// && (setMonitor852e922(u, "F_{[100, 101, 107, 112, 116, 117, 118, 119, 120, 121, 123, 124, 125, 126, 128, 129, 96, 97, 98, 99]}"))) {
// Verification.fail(" FAILED ON REGEXP UNEXPECT ((((!(openSession))* ; (((openSession ; (!(closeSession))*) ; closeSession))*) ; (!(openSession))*) ; log)");}
//
//   else if ( checkMonitor852e922(u, "N_{[104, 105, 106, 108, 110, 114]}")
// && (setMonitor852e922(u, "N_{[104, 105, 106, 108, 110, 114]}"))) {}
//
//   else if ( checkMonitor852e922(u, "N_{[100, 101, 107, 111, 112, 113, 116, 118, 119, 120, 123, 124, 125, 129]}")
// && (setMonitor852e922(u, "F_{[119, 120, 121, 123, 125, 126, 128, 129]}"))) {
// Verification.fail(" FAILED ON REGEXP UNEXPECT ((((!(openSession))* ; (((openSession ; (!(closeSession))*) ; closeSession))*) ; (!(openSession))*) ; log)");}
//
//   else if ( checkMonitor852e922(u, "F_{[119, 120, 121, 123, 125, 126, 128, 129]}")
// && (setMonitor852e922(u, "F_{[119, 120, 121, 123, 125, 126, 128, 129]}"))) {
// Verification.fail(" FAILED ON REGEXP UNEXPECT ((((!(openSession))* ; (((openSession ; (!(closeSession))*) ; closeSession))*) ; (!(openSession))*) ; log)");}
//
//   else if ( checkMonitor852e922(u, "N_{[119, 120, 121, 123, 125, 129]}")
// && (setMonitor852e922(u, "F_{[119, 120, 121, 123, 125, 126, 128, 129]}"))) {
// Verification.fail(" FAILED ON REGEXP UNEXPECT ((((!(openSession))* ; (((openSession ; (!(closeSession))*) ; closeSession))*) ; (!(openSession))*) ; log)");}
//
//   else if ( checkMonitor852e922(u, "N_131")
// && (setMonitor852e922(u, "N_131"))) {}
//}
//
//
//before (UserSession u): call(* *.openSession(..)) &&
//    target(u){ 
// if (1==0) {}
//   else if ( checkMonitor852e922(u, "N_131")
// && (setMonitor852e922(u, "N_131"))) {}
//
//   else if ( checkMonitor852e922(u, "F_{[119, 120, 121, 123, 125, 126, 128, 129]}")
// && (setMonitor852e922(u, "N_131"))) {}
//
//   else if ( checkMonitor852e922(u, "N_{[119, 120, 121, 123, 125, 129]}")
// && (setMonitor852e922(u, "N_131"))) {}
//
//   else if ( checkMonitor852e922(u, "S_{[100, 101, 107, 112, 115, 116, 117, 118, 119, 120, 122, 123, 124, 125, 127, 129, 130, 95, 96, 97, 99]}")
// && (setMonitor852e922(u, "N_{[102, 103, 104, 105, 108, 109, 110, 114]}"))) {}
//
//   else if ( checkMonitor852e922(u, "F_{[100, 101, 107, 112, 116, 117, 118, 119, 120, 121, 123, 124, 125, 126, 128, 129, 96, 97, 98, 99]}")
// && (setMonitor852e922(u, "N_{[102, 103, 104, 105, 108, 109, 110, 114]}"))) {}
//
//   else if ( checkMonitor852e922(u, "N_{[102, 103, 104, 105, 108, 109, 110, 114]}")
// && (setMonitor852e922(u, "N_{[104, 105, 106, 108, 110, 114]}"))) {}
//
//   else if ( checkMonitor852e922(u, "N_{[100, 101, 107, 112, 116, 117, 118, 119, 120, 121, 123, 124, 125, 129, 96, 97, 98, 99]}")
// && (setMonitor852e922(u, "N_{[102, 103, 104, 105, 108, 109, 110, 114]}"))) {}
//
//   else if ( checkMonitor852e922(u, "N_{[104, 105, 106, 108, 110, 114]}")
// && (setMonitor852e922(u, "N_{[104, 105, 106, 108, 110, 114]}"))) {}
//
//   else if ( checkMonitor852e922(u, "N_{[100, 101, 107, 111, 112, 113, 116, 118, 119, 120, 123, 124, 125, 129]}")
// && (setMonitor852e922(u, "N_{[102, 103, 104, 105, 108, 109, 110, 114]}"))) {}
//}
//
//
//before (UserSession u): call(* *.closeSession(..)) &&
//    target(u){ 
// if (1==0) {}
//   else if ( checkMonitor852e922(u, "S_{[100, 101, 107, 112, 115, 116, 117, 118, 119, 120, 122, 123, 124, 125, 127, 129, 130, 95, 96, 97, 99]}")
// && (setMonitor852e922(u, "N_{[100, 101, 107, 112, 116, 117, 118, 119, 120, 121, 123, 124, 125, 129, 96, 97, 98, 99]}"))) {}
//
//   else if ( checkMonitor852e922(u, "F_{[100, 101, 107, 112, 116, 117, 118, 119, 120, 121, 123, 124, 125, 126, 128, 129, 96, 97, 98, 99]}")
// && (setMonitor852e922(u, "N_{[100, 101, 107, 112, 116, 117, 118, 119, 120, 121, 123, 124, 125, 129, 96, 97, 98, 99]}"))) {}
//
//   else if ( checkMonitor852e922(u, "N_{[102, 103, 104, 105, 108, 109, 110, 114]}")
// && (setMonitor852e922(u, "N_{[100, 101, 107, 111, 112, 113, 116, 118, 119, 120, 123, 124, 125, 129]}"))) {}
//
//   else if ( checkMonitor852e922(u, "N_{[100, 101, 107, 112, 116, 117, 118, 119, 120, 121, 123, 124, 125, 129, 96, 97, 98, 99]}")
// && (setMonitor852e922(u, "N_{[100, 101, 107, 112, 116, 117, 118, 119, 120, 121, 123, 124, 125, 129, 96, 97, 98, 99]}"))) {}
//
//   else if ( checkMonitor852e922(u, "N_{[104, 105, 106, 108, 110, 114]}")
// && (setMonitor852e922(u, "N_{[100, 101, 107, 111, 112, 113, 116, 118, 119, 120, 123, 124, 125, 129]}"))) {}
//
//   else if ( checkMonitor852e922(u, "N_{[100, 101, 107, 111, 112, 113, 116, 118, 119, 120, 123, 124, 125, 129]}")
// && (setMonitor852e922(u, "N_{[119, 120, 121, 123, 125, 129]}"))) {}
//
//   else if ( checkMonitor852e922(u, "F_{[119, 120, 121, 123, 125, 126, 128, 129]}")
// && (setMonitor852e922(u, "N_{[119, 120, 121, 123, 125, 129]}"))) {}
//
//   else if ( checkMonitor852e922(u, "N_{[119, 120, 121, 123, 125, 129]}")
// && (setMonitor852e922(u, "N_{[119, 120, 121, 123, 125, 129]}"))) {}
//
//   else if ( checkMonitor852e922(u, "N_131")
// && (setMonitor852e922(u, "N_131"))) {}
//}
//
//
//public static void initialise() {init5db9742(); 
//initd06d69c(); 
//init852e922(); 
//
//}
}

/*This file is part of ARVISummerSchoolCode.

Copyright (C) 2016  Christian Colombo
Modified by Avinash Chatlani 2018
ARVISummerSchoolCode is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

ARVISummerSchoolCode is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with files from ARVISummerSchoolCode.  If not, see <http://www.gnu.org/licenses/>.
*/
