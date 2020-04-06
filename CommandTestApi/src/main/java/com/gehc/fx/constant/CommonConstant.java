package com.gehc.fx.constant;

import org.springframework.stereotype.Component;

@Component
public class CommonConstant {

	public static final String FIRST = "cut -d',' -f2 %s | LANG=C sed 's/[\\d128-\\d255]//g' | awk '{print tolower($0)}' | sed -e \"s/[^a-z0-9]//g\" | sed -r '/^.{,2}$/d' | sed -r '/^.{21,}$/d' | sort | egrep -v \"^(needed|na|exchange|unknown|none|notreqd|nsn|needserialnumber|dup|tbd|feverify|notreqrd|noserial|needserial|notavailable|nogecontract|need|nosn|notrqrd|notavail|noserial1|.*missing.*)$\" >> %sserial_numbers_Siebel_all.txt";

	public static final String SECOND = "cat %sserial_numbers_Siebel_all.txt | uniq -c | grep \"      1 \" | sed 's/      1 //g' > %slist_serial_numbers_Siebel_unique.txt";

	public static final String THIRD = "ccat %sserial_numbers_Siebel_all.txt | uniq -d | sort -u > %slist_serial_numbers_Siebel_ambiguous.txt";

	public static final String FOURTH = "cat %slist_serial_numbers_Siebel_unique.txt | sed 's/a/2/g' | sed 's/b/2/g' | sed 's/c/2/g' | sed 's/d/3/g' | sed 's/e/3/g' | sed 's/f/3/g' | sed 's/g/4/g' | sed 's/h/4/g' | sed 's/i/4/g' | sed 's/j/5/g' | sed 's/k/5/g' | sed 's/l/5/g' | sed 's/m/6/g' | sed 's/n/6/g' | sed 's/o/6/g' | sed 's/p/7/g' | sed 's/q/7/g' | sed 's/r/7/g' | sed 's/s/7/g' | sed 's/t/8/g' | sed 's/u/8/g' | sed 's/v/8/g' | sed 's/w/9/g' | sed 's/x/9/g' | sed 's/y/9/g' | sed 's/z/9/g' | sort -u > %slist_serial_numbers_Siebel_unique_dtmf.txt";

	public static final String FIFTH = "cat %slist_serial_numbers_Siebel_ambiguous.txt | sed 's/a/2/g' | sed 's/b/2/g' | sed 's/c/2/g' | sed 's/d/3/g' | sed 's/e/3/g' | sed 's/f/3/g' | sed 's/g/4/g' | sed 's/h/4/g' | sed 's/i/4/g' | sed 's/j/5/g' | sed 's/k/5/g' | sed 's/l/5/g' | sed 's/m/6/g' | sed 's/n/6/g' | sed 's/o/6/g' | sed 's/p/7/g' | sed 's/q/7/g' | sed 's/r/7/g' | sed 's/s/7/g' | sed 's/t/8/g' | sed 's/u/8/g' | sed 's/v/8/g' | sed 's/w/9/g' | sed 's/x/9/g' | sed 's/y/9/g' | sed 's/z/9/g' | sort -u | sed 's/$/|1/g' | sed '1 i\\UTF-8' > %slist_serial_numbers_Siebel_ambiguous_dtmf.txt";

}
