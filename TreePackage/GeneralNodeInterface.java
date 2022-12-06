package TreePackage;
import java.util.Iterator;
interface GeneralNodeInterface<T>
{
public T getData();
public void setData(T newData);
public boolean isLeaf();
public Iterator<GeneralNodeInterface<T>> getChildrenIterator();
public void addChild(GeneralNodeInterface<T> newChild);
} // end GeneralNodeInterface
