package ca.vgorcinschi.algorithms_1_4_2
/**
  * Created by vgorcinschi on 26/03/17.
  */
object HalfMergeSort extends App{
  var counter = 0

  def merge(first: Array[Int], second: Array[Int]):Unit={
    //the passed-in arrays are already sorted
    val result = mergeHelper(first.toList, second.toList, List())
    println(s"${result.mkString("{",",","}")} with a length of ${result.length}" +
      s" was sorted in $counter steps")
  }

  def mergeHelper(a: List[Int], b: List[Int], result: List[Int]):List[Int]={
    counter+=1
    (a, b) match {
      case (Nil, Nil) => result
      case (as, Nil) => result ++ as
      case (Nil, bs) => result ++ bs
      case (a1::as, b1::bs) => {
        if(a1<b1)mergeHelper(as, b, result:+a1)
        else mergeHelper(a, bs, result:+b1)
      }
    }
  }

  merge(Array(1,3,5,7,9,11), Array(2,4,6,8,10))
}
