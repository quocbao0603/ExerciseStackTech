namespace java basictutorial
namespace cpp basictutorial

typedef i32 int
typedef i64 long
//service BasicThriftService	
//{
//        int put(1:string key, 2:i32 n1, 3:int n2),
//}

struct MyData {
  1: string s,
  2: list<i32> lst,
}

struct MyValue {
  1: i32 p2, 
  2: i64 p3, 
  3: string p4, 	
  4: list<i32> p5, 
  5: map<string,string> p6, 
  6: MyData p7, 
  7: i32 errCode, 
}
service BasicThriftService		
{	
	i64 put(1: string key,2: i32 p2,3: i64 p3,4: string p4,5: list<i32> p5,6: map<string,string> p6,7: MyData p7),
	oneway void put2(1: string key,2: i32 p2,3: i64 p3,4: string p4,5: list<i32> p5,6: map<string,string> p6,7: MyData p7),

	i64 put3(1: string key,2: i32 p2,3: i64 p3,4: string p4,5: list<i32> p5,6: optional map<string,string> p6,7: required MyData p7),

 	MyValue get(1: string key),
}
