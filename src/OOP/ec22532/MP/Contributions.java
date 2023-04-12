package OOP.ec22532.MP;

class Contributions {
  
  static Room newRoomByUsername(String s) {
    Room x = null;
  
    if (s.equals("ec22532")) x = new Room_ec22532();
    else if (s.equals("ec22929")) x = new Room_ec22929();
    else if (s.equals("ec22842")) x = new Room_ec22842();
    
    return x;
  }
  
  static String[] getRoomUsernames() {
    String[] a = new String[396];
      a[0] = "ah21407";
      a[1] = "bt21057";
      a[2] = "cb21793";
      a[3] = "ec19389";
      a[4] = "ec20258";
      a[5] = "ec20315";
      a[6] = "ec211030";
      a[7] = "ec211044";
      a[8] = "ec211045";
      a[9] = "ec21403";
      a[10] = "ec21413";
      a[11] = "ec21494";
      a[12] = "ec21499";
      a[13] = "ec21504";
      a[14] = "ec21578";
      a[15] = "ec21582";
      a[16] = "ec21645";
      a[17] = "ec21841";
      a[18] = "ec221002";
      a[19] = "ec221003";
      a[20] = "ec221004";
      a[21] = "ec221006";
      a[22] = "ec221008";
      a[23] = "ec221011";
      a[24] = "ec221012";
      a[25] = "ec221013";
      a[26] = "ec221014";
      a[27] = "ec221015";
      a[28] = "ec221016";
      a[29] = "ec221017";
      a[30] = "ec221021";
      a[31] = "ec221022";
      a[32] = "ec221023";
      a[33] = "ec221024";
      a[34] = "ec221025";
      a[35] = "ec221028";
      a[36] = "ec221085";
      a[37] = "ec221099";
      a[38] = "ec221136";
      a[39] = "ec221148";
      a[40] = "ec221150";
      a[41] = "ec221156";
      a[42] = "ec221183";
      a[43] = "ec221185";
      a[44] = "ec221193";
      a[45] = "ec221204";
      a[46] = "ec221208";
      a[47] = "ec221218";
      a[48] = "ec221247";
      a[49] = "ec22406";
      a[50] = "ec22409";
      a[51] = "ec22411";
      a[52] = "ec22412";
      a[53] = "ec22413";
      a[54] = "ec22414";
      a[55] = "ec22415";
      a[56] = "ec22418";
      a[57] = "ec22419";
      a[58] = "ec22420";
      a[59] = "ec22421";
      a[60] = "ec22422";
      a[61] = "ec22425";
      a[62] = "ec22426";
      a[63] = "ec22429";
      a[64] = "ec22430";
      a[65] = "ec22431";
      a[66] = "ec22432";
      a[67] = "ec22433";
      a[68] = "ec22434";
      a[69] = "ec22435";
      a[70] = "ec22436";
      a[71] = "ec22437";
      a[72] = "ec22439";
      a[73] = "ec22441";
      a[74] = "ec22442";
      a[75] = "ec22443";
      a[76] = "ec22445";
      a[77] = "ec22446";
      a[78] = "ec22447";
      a[79] = "ec22448";
      a[80] = "ec22449";
      a[81] = "ec22450";
      a[82] = "ec22451";
      a[83] = "ec22452";
      a[84] = "ec22454";
      a[85] = "ec22456";
      a[86] = "ec22459";
      a[87] = "ec22462";
      a[88] = "ec22464";
      a[89] = "ec22466";
      a[90] = "ec22467";
      a[91] = "ec22468";
      a[92] = "ec22471";
      a[93] = "ec22473";
      a[94] = "ec22475";
      a[95] = "ec22476";
      a[96] = "ec22478";
      a[97] = "ec22479";
      a[98] = "ec22480";
      a[99] = "ec22484";
      a[100] = "ec22485";
      a[101] = "ec22486";
      a[102] = "ec22489";
      a[103] = "ec22494";
      a[104] = "ec22496";
      a[105] = "ec22497";
      a[106] = "ec22503";
      a[107] = "ec22507";
      a[108] = "ec22508";
      a[109] = "ec22510";
      a[110] = "ec22513";
      a[111] = "ec22517";
      a[112] = "ec22518";
      a[113] = "ec22519";
      a[114] = "ec22520";
      a[115] = "ec22521";
      a[116] = "ec22522";
      a[117] = "ec22524";
      a[118] = "ec22529";
      a[119] = "ec22532";
      a[120] = "ec22535";
      a[121] = "ec22537";
      a[122] = "ec22541";
      a[123] = "ec22542";
      a[124] = "ec22543";
      a[125] = "ec22545";
      a[126] = "ec22546";
      a[127] = "ec22547";
      a[128] = "ec22548";
      a[129] = "ec22549";
      a[130] = "ec22551";
      a[131] = "ec22552";
      a[132] = "ec22553";
      a[133] = "ec22557";
      a[134] = "ec22558";
      a[135] = "ec22559";
      a[136] = "ec22560";
      a[137] = "ec22561";
      a[138] = "ec22562";
      a[139] = "ec22563";
      a[140] = "ec22566";
      a[141] = "ec22568";
      a[142] = "ec22569";
      a[143] = "ec22570";
      a[144] = "ec22572";
      a[145] = "ec22573";
      a[146] = "ec22576";
      a[147] = "ec22578";
      a[148] = "ec22579";
      a[149] = "ec22581";
      a[150] = "ec22582";
      a[151] = "ec22583";
      a[152] = "ec22585";
      a[153] = "ec22586";
      a[154] = "ec22587";
      a[155] = "ec22589";
      a[156] = "ec22591";
      a[157] = "ec22592";
      a[158] = "ec22593";
      a[159] = "ec22597";
      a[160] = "ec22598";
      a[161] = "ec22599";
      a[162] = "ec22601";
      a[163] = "ec22602";
      a[164] = "ec22605";
      a[165] = "ec22612";
      a[166] = "ec22614";
      a[167] = "ec22615";
      a[168] = "ec22616";
      a[169] = "ec22617";
      a[170] = "ec22618";
      a[171] = "ec22621";
      a[172] = "ec22623";
      a[173] = "ec22625";
      a[174] = "ec22626";
      a[175] = "ec22627";
      a[176] = "ec22628";
      a[177] = "ec22630";
      a[178] = "ec22632";
      a[179] = "ec22634";
      a[180] = "ec22635";
      a[181] = "ec22636";
      a[182] = "ec22638";
      a[183] = "ec22641";
      a[184] = "ec22642";
      a[185] = "ec22645";
      a[186] = "ec22646";
      a[187] = "ec22648";
      a[188] = "ec22649";
      a[189] = "ec22652";
      a[190] = "ec22657";
      a[191] = "ec22658";
      a[192] = "ec22660";
      a[193] = "ec22661";
      a[194] = "ec22662";
      a[195] = "ec22664";
      a[196] = "ec22666";
      a[197] = "ec22668";
      a[198] = "ec22671";
      a[199] = "ec22672";
      a[200] = "ec22675";
      a[201] = "ec22677";
      a[202] = "ec22678";
      a[203] = "ec22680";
      a[204] = "ec22692";
      a[205] = "ec22695";
      a[206] = "ec22696";
      a[207] = "ec22697";
      a[208] = "ec22702";
      a[209] = "ec22703";
      a[210] = "ec22704";
      a[211] = "ec22707";
      a[212] = "ec22708";
      a[213] = "ec22709";
      a[214] = "ec22711";
      a[215] = "ec22716";
      a[216] = "ec22717";
      a[217] = "ec22718";
      a[218] = "ec22720";
      a[219] = "ec22722";
      a[220] = "ec22723";
      a[221] = "ec22724";
      a[222] = "ec22726";
      a[223] = "ec22738";
      a[224] = "ec22739";
      a[225] = "ec22740";
      a[226] = "ec22741";
      a[227] = "ec22742";
      a[228] = "ec22743";
      a[229] = "ec22746";
      a[230] = "ec22748";
      a[231] = "ec22749";
      a[232] = "ec22751";
      a[233] = "ec22752";
      a[234] = "ec22753";
      a[235] = "ec22754";
      a[236] = "ec22758";
      a[237] = "ec22760";
      a[238] = "ec22761";
      a[239] = "ec22763";
      a[240] = "ec22764";
      a[241] = "ec22765";
      a[242] = "ec22766";
      a[243] = "ec22770";
      a[244] = "ec22771";
      a[245] = "ec22772";
      a[246] = "ec22776";
      a[247] = "ec22777";
      a[248] = "ec22779";
      a[249] = "ec22784";
      a[250] = "ec22786";
      a[251] = "ec22787";
      a[252] = "ec22789";
      a[253] = "ec22790";
      a[254] = "ec22791";
      a[255] = "ec22792";
      a[256] = "ec22793";
      a[257] = "ec22795";
      a[258] = "ec22798";
      a[259] = "ec22801";
      a[260] = "ec22802";
      a[261] = "ec22804";
      a[262] = "ec22808";
      a[263] = "ec22809";
      a[264] = "ec22814";
      a[265] = "ec22815";
      a[266] = "ec22816";
      a[267] = "ec22817";
      a[268] = "ec22819";
      a[269] = "ec22820";
      a[270] = "ec22824";
      a[271] = "ec22825";
      a[272] = "ec22827";
      a[273] = "ec22828";
      a[274] = "ec22830";
      a[275] = "ec22836";
      a[276] = "ec22837";
      a[277] = "ec22838";
      a[278] = "ec22840";
      a[279] = "ec22841";
      a[280] = "ec22843";
      a[281] = "ec22845";
      a[282] = "ec22846";
      a[283] = "ec22852";
      a[284] = "ec22857";
      a[285] = "ec22858";
      a[286] = "ec22859";
      a[287] = "ec22860";
      a[288] = "ec22861";
      a[289] = "ec22862";
      a[290] = "ec22863";
      a[291] = "ec22866";
      a[292] = "ec22867";
      a[293] = "ec22871";
      a[294] = "ec22872";
      a[295] = "ec22875";
      a[296] = "ec22877";
      a[297] = "ec22879";
      a[298] = "ec22880";
      a[299] = "ec22881";
      a[300] = "ec22882";
      a[301] = "ec22883";
      a[302] = "ec22885";
      a[303] = "ec22887";
      a[304] = "ec22888";
      a[305] = "ec22889";
      a[306] = "ec22890";
      a[307] = "ec22891";
      a[308] = "ec22893";
      a[309] = "ec22894";
      a[310] = "ec22895";
      a[311] = "ec22897";
      a[312] = "ec22898";
      a[313] = "ec22899";
      a[314] = "ec22900";
      a[315] = "ec22902";
      a[316] = "ec22906";
      a[317] = "ec22908";
      a[318] = "ec22909";
      a[319] = "ec22911";
      a[320] = "ec22912";
      a[321] = "ec22913";
      a[322] = "ec22914";
      a[323] = "ec22917";
      a[324] = "ec22919";
      a[325] = "ec22923";
      a[326] = "ec22925";
      a[327] = "ec22926";
      a[328] = "ec22927";
      a[329] = "ec22928";
      a[330] = "ec22929";
      a[331] = "ec22932";
      a[332] = "ec22934";
      a[333] = "ec22935";
      a[334] = "ec22937";
      a[335] = "ec22938";
      a[336] = "ec22940";
      a[337] = "ec22941";
      a[338] = "ec22943";
      a[339] = "ec22944";
      a[340] = "ec22945";
      a[341] = "ec22946";
      a[342] = "ec22948";
      a[343] = "ec22952";
      a[344] = "ec22954";
      a[345] = "ec22955";
      a[346] = "ec22959";
      a[347] = "ec22960";
      a[348] = "ec22962";
      a[349] = "ec22965";
      a[350] = "ec22967";
      a[351] = "ec22972";
      a[352] = "ec22973";
      a[353] = "ec22974";
      a[354] = "ec22975";
      a[355] = "ec22977";
      a[356] = "ec22979";
      a[357] = "ec22981";
      a[358] = "ec22982";
      a[359] = "ec22984";
      a[360] = "ec22986";
      a[361] = "ec22987";
      a[362] = "ec22990";
      a[363] = "ec22992";
      a[364] = "ec22993";
      a[365] = "ec22995";
      a[366] = "eey577";
      a[367] = "ex20181";
      a[368] = "ex20539";
      a[369] = "ex21213";
      a[370] = "ex21247";
      a[371] = "ex21299";
      a[372] = "ex21327";
      a[373] = "ex21329";
      a[374] = "ex21362";
      a[375] = "ex21405";
      a[376] = "ex21423";
      a[377] = "ex21495";
      a[378] = "ex21566";
      a[379] = "ex21626";
      a[380] = "jpp301711";
      a[381] = "jpp308479";
      a[382] = "jpp314171";
      a[383] = "jpp317487";
      a[384] = "jpp319457";
      a[385] = "jpp324787";
      a[386] = "jpp335448";
      a[387] = "lt19211";
    
    return a;
  }
}
