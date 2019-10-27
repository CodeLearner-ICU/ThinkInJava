

## 5.6 练习

 1.  用 public、private、protected 以及“友好的”数据成员及方法成员创建一个类。创建属于这个类的一个对象，  
并观察在试图访问所有类成员时会获得哪种类型的编译器错误提示。注意同一个目录内的类属于  
“默认”包的一部分。 
 2. 用 protected 数据创建一个类。在相同的文件里创建第二个类，用一个方法操纵第一个类里的protected 数据。  
 3. 新建一个目录，并编辑自己的 CLASSPATH，以便包括那个新目录。将P.class 文件复制到自己的新目录，  
然后改变文件名、P 类以及方法名（亦可考虑添加额外的输出，观察它的运行过程）。在一个不同的目录里创建另一个程序，令其使用自己的新类。   
 4. 在 c05 目录（假定在自己的CLASSPATH 里）创建下述文件：  
//: PackagedClass.java package c05;   
class PackagedClass {  
    public PackagedClass() {  
        System.out.println(  
        "Creating a packaged class");  
    }  
}  
 ///:然后在 c05 之外的另一个目录里创建下述文件： //: Foreign.java   
package c05.foreign;   
import c05.*;   
public class Foreign {   
    public static void main (String[] args) {  
        PackagedClass pc = new PackagedClass();  
    }  
}   
///:解释编译器为什么会产生一个错误。将Foreign（外部）类作为c05 包的一部分改变了什么东西吗？