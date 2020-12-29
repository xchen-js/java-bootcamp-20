package com.coderscampus.arraylist;


public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object [10];
	int size =0;

	@Override
	public boolean add(T item) {
		 
		if (items.length==size) {
			//double array size			 
			Object [] newItems = new Object [size*2];
			//copy over from original array
			for (int j=0;j<items.length;j++) {
				newItems[j]=items[j];
			}	
			items = newItems;
		}
		items[size]=item;
		size++;
		return true;
		
	}

	public Object[] getItems() {
		return items;
	}



	public void setItems(Object[] items) {
		this.items = items;
	}



	@Override
	public int getSize() {
	  return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {

	 if (index<items.length && items[index]!=null) {
			return (T)items[index];
	 }else {
		 return null;
	 }
	}
	
}
