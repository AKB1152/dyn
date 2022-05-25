package com.akb.dyn;

import java.util.Scanner;

import com.akb.dyn.Dyncache.Mode;

public class Main {
	
	public static void main(String[] args) {
		Dyncache<String> dyn = new Dyncache<>(Mode.STACK);
		
		Scanner sc = new Scanner(System.in, "utf-8");
		String tmp = ""; 
		while (tmp != ":qa") {
			System.out.printf("[%s MODE]: enter command [Add <Value>|Switch [MODE]|Remove|:qa]\n $", dyn.getMode());
			tmp = sc.nextLine();
			switch (tmp.toLowerCase().split(" ")[0]) {

				case "add":
				case "a":
					dyn.push(tmp.substring(1+tmp.indexOf(" ")));
					System.err.println("[+] "+tmp.substring(1+tmp.indexOf(" ")));
					break;
				
				case "switch":
				case "s":
					dyn.setMode(Mode.valueOf(tmp.substring(1+tmp.indexOf(" ")).toUpperCase()));
					break;

				case "r":
				case "rm":
				case "remove":
					System.err.println("[-] "+dyn.pop());
					break;
				
				case ":q":
				case "exit":
				case ":qa":
					tmp = ":qa";
					break;

				default:
					System.err.println("Command "+tmp+" invalid");
			}
		}

		sc.close();
		// pop all left
		while (dyn.size() > 0) System.err.printf("[LEFT %d]: %s\n",dyn.size()-1, dyn.pop());
		System.exit(0);
	}
}
