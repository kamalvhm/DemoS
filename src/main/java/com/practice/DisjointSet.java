package com.practice;
import java.util.ArrayList;
import java.util.List;


class DisjointSet {
	List<Integer> parent=new ArrayList<>();
	List<Integer> rank=new ArrayList<>();
	List<Integer> size=new ArrayList<>();
	
	DisjointSet(int n){
		for(int i=0;i<n+1;i++) {
			parent.add(i);
			rank.add(0);
			size.add(1);
		}
		
	}
	
	public int findUPar(int node) {
		if(node==parent.get(node))return node;
		int ulp=findUPar(parent.get(node));
		parent.set(node, ulp);
		return parent.get(node);
	}
	
	public void unionByRank(int u,int v) {
		int ulp_u=findUPar(u);
		int ulp_v=findUPar(v);
		if(ulp_u==ulp_v)return;
		if(rank.get(ulp_u)<rank.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
		}else if(rank.get(ulp_u)>rank.get(ulp_v)) {
			parent.set(ulp_v, ulp_u);
		}else {
			parent.set(ulp_v, ulp_u);
			int rankU=rank.get(ulp_u);
			rank.set(ulp_u, rankU+1);
		}
	}
	
	public void unionBySize(int u,int v) {
		int ulp_u=findUPar(u);
		int ulp_v=findUPar(v);
		if(ulp_u==ulp_v)return;
		if(size.get(ulp_u)<size.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
		} else {
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
		}
	}
	public static void main(String args[]) {
		DisjointSet ds=new DisjointSet(4);
		ds.unionByRank(0, 1);
		ds.unionByRank(1, 2);
		
		System.out.println("Is 1 and 3 in same component "+(ds.findUPar(1)==ds.findUPar(3)));
		ds.unionByRank(2, 3);
		System.out.println("Is 1 and 3 in same component "+(ds.findUPar(1)==ds.findUPar(3)));



	}
	
}
