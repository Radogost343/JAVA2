/*
 1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
 10 3 1 2
 2 3 2 2
 5 6 7 1
 300 3 1 0
 Написать метод, на вход которого подаётся такая строка,
 метод должен преобразовать строку в двумерный массив типа String[][];

 2. Преобразовать все элементы массива в числа типа int,
  просуммировать, поделить полученную сумму на 2, и вернуть результат;

 3. Ваши методы должны бросить исключения в случаях:
    Если размер матрицы, полученной из строки, не равен 4x4;

    Если в одной из ячеек полученной матрицы не число; (например символ или слово)

 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.

 5. * Написать собственные классы исключений для каждого из случаев
 */

public class lesson2 {

    public static void main(String[] args) throws MyException {
        System.out.println(SumArray.SumArrayEqual2(changeStringToArr("10 3 1 2 2 3 2 2 5 6 7 1 300 3 1 0")));
    }

    static String [][] changeStringToArr(String s) {
        String[] arr = s.split(" ");
        String[][] newArr = new String[4][4];
        for (int i = 0; i < newArr.length * newArr.length; i++) {
        newArr[i / newArr.length][i % newArr.length] = arr[i];
        }
        return newArr;
    }

    public static class SumArray {
      static int SumArrayEqual2 (String [][] newArr) throws MyException {
          int sum = 0;
          int j = 0;
          int [][] newArrInt = new int[newArr.length][newArr.length];
          if (newArr.length != 4) {
              throw new MyException("Как у тебя получилось? Неверный размер массива))");
          }
          try {
              for (int i = 0; i < newArrInt.length*newArrInt.length; i++) {
                  newArrInt[i/newArrInt.length][i%newArrInt.length] = Integer.parseInt(newArr[i/newArr.length][i%newArr.length]);
                  sum += newArrInt[i/newArrInt.length][i%newArrInt.length];
              }
          } catch (NumberFormatException input) {
              System.err.println("Wrong input. In line mast be numbers!!!");
          } catch (ArrayIndexOutOfBoundsException input) {
              System.err.println("Ошибка индексации массива");
          } catch (RuntimeException input){
              System.err.println("Runtime error");
          } catch (Exception e){
              System.err.println("nothing2");
          }
          return sum / 2;
      }
    }

    public static class MyException extends Exception {
        public MyException(String s) {
            super();
            System.err.println("Неверный размер массива!!! 16 чисел.");
        }
    }
}
