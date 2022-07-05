//package practices.musinsa;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Stack;
//import java.util.TreeMap;
//
//public class mu2 {
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    int[] answer = solution.solution(
//        new String[]{"azad", "andy", "louis", "will", "edward"},
//        new int[][]{{3, 4}, {-1, 5}, {-4, 4}, {3, 4}, {-5, 0}},
//        new double[]{4.19, 3.77, 4.41, 3.65, 3.58}
//    );
//
//    for (int s : answer) {
//      System.out.print(s);
//    }
//  }
//
//  static class Solution {
//    public int[] solution(String[] names, int[][] homes, double[] grades) {
//      //1차 정렬 및 매핑
//      Map<Double, Student> students = new TreeMap<>();
//      List<String> rank = new ArrayList<>();
//
//      for(int i = 0; i < names.length; i++) {
//        students.put(grades[i], new Student(names[i], homes[i], grades[i]));
//      }
//
//      Stack<Student> stack = new Stack();
//      for (Entry<Double, Student> doubleStudentEntry : students.entrySet()) {
//        if(!rank.contains(doubleStudentEntry.getValue().getName())) {
//          stack.add(doubleStudentEntry.getValue());
//        }
//      }
//      while(true) {
//
//        if(stack.isEmpty()){
//          break;
//        }
//
//        Student first = stack.pop();
//        if(rank.contains(first.getName())) {
//          continue;
//        }
//
//        if(stack.isEmpty()) {
//          continue;
//        }
//        Student next = stack.peek();
//
//        if(!gradeTest(first,next)) {
//          rank.add(first.getName());
//        } else { //점수가 같으면 거리 비교
//          double grade = first.getGrade();
//          List list = new ArrayList();
//          list.add(first);
//          distance.put(first.getDistance(), list);
//          for (Student student : stack) {
//             if(student.getGrade() == grade) {
//               distance.put(student.getDistance(), student);
//             }
//          }
//          Stack<Student> distanceStack = new Stack();
//          for (Entry<Double, Student> distances : distance.entrySet()) {
//            distanceStack.add(distances.getValue());
//          }
//
//          Student firstD = distanceStack.pop();
//
//          if(distanceStack.isEmpty()) {
//            continue;
//          }
//
//          Student nextD = distanceStack.peek();
//
//          if(!distanceTest(firstD, nextD)){
//            rank.add(firstD.getName());
//          } else {
//            distanceStack.push(firstD);
//            double distanceD = firstD.getDistance();
//
//            Map<Double, Student> nameMap = new TreeMap<>();
//            nameMap.put(distanceD, firstD);
//            for (Student student : distanceStack) {
//              if(distanceD == student.getDistance()) {
//                nameMap.put(student.getDistance(), student);
//              }
//            }
//
//            Stack<Student> nameStack = new Stack();
//            for (Entry<Double, Student> nameEntries : nameMap.entrySet()) {
//              nameStack.add(nameEntries.getValue());
//            }
//
//            Student firstN = distanceStack.pop();
//
//            rank.add(firstN.getName());
//          }
//        }
//      }
//
//
//      int[] answer = new int[names.length];
//      int i = 0;
//      for (String name : names) {
//        answer[i++] = rank.indexOf(name) + 1;
//      }
//
//      return answer;
//    }
//  }
//
//  private static boolean gradeTest(Student first, Student next){
//    return first.getGrade() == next.getGrade();
//  }
//
//  private static boolean distanceTest(Student first, Student next){
//    return first.getDistance() == next.getDistance();
//  }
//
//  private void nameTest(){
//
//  }
//
//  static class Student {
//    private String name;
//    private double distance;
//    private double grade;
//
//    public Student(String name, int[] home, double grade) {
//      this.name = name;
//      this.distance = caculate(0, 0, home[0], home[1]);
//      this.grade = Math.floor(grade);
//    }
//
//    public String getName(){
//      return this.name;
//    }
//    public double getGrade(){
//      return this.grade;
//    }
//
//    public double getDistance(){
//      return this.distance;
//    }
//
//    private double caculate(int x, int y, int x1, int y1){
//      return Math.sqrt(Math.pow(Math.abs(x1-x), 2) + Math.pow(Math.abs(y1-y), 2));
//    }
//  }
//
//}
