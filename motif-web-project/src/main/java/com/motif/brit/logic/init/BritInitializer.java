package com.motif.brit.logic.init;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.motif.brit.state.BritArea;
import com.motif.brit.state.BritBorder;
import com.motif.brit.state.BritGame;
import com.motif.brit.state.BritInfantry;
import com.motif.brit.state.BritLandArea;
import com.motif.brit.state.BritNation;
import com.motif.brit.state.BritPlayer;
import com.motif.brit.state.BritSeaArea;
import com.motif.brit.state.BritTimelineElement;
import com.motif.brit.state.BritUnit;
import com.motif.brit.state.BritArea.BritAreaType;
import com.motif.brit.state.BritBorder.BritBorderType;
import com.motif.brit.state.BritNation.BritColor;

public class BritInitializer {

	private BritNation romans, romano_british, normans, saxons, danes, norwegians, jutes, angles;
	private BritNation belgae, welsh, brigantes, caledonians, picts, irish, scots, norsemen, dubliners;
	
	private BritArea avalon, downlands, wessex, sussex, kent, essex, lindsey, suffolk, norfolk, south_mercia, north_mercia;
	private BritArea hwicce, devon, cornwall, gwent, dyfed, powys, gwynedd, clwyd, march, cheshire, york, bernicia;
	private BritArea pennines, cumbria, lothian, galloway, dunedin, strathclyde, dalriada, alban, mar, moray, skye, caithness, orkneys, hebrides;
	private BritArea icelandic_sea, north_sea, frisian_sea, english_channel, irish_sea, atlantic_ocean;
	
	public BritGame init () {
		BritGame game = null;
		
		BritPlayer leo = new BritPlayer ("leo", "Leo");
		BritPlayer nico = new BritPlayer ("nico", "Nico");
		BritPlayer rob = new BritPlayer ("rob", "Rob");
		BritPlayer salv = new BritPlayer ("salv", "Salv");
		
		game = new BritGame ();
		game.initPlayer (leo);
		game.initPlayer (nico);
		game.initPlayer (rob);
		game.initPlayer (salv);
		
		initNations (game, leo, nico, rob, salv);
		initUnits (game);
		initAreas (game);
		initBorders ();
		initTimeline (game);
		
		return game;
	} // init
	
	private void initTimeline (BritGame game) {
		ArrayList<BritTimelineElement> round1 = new ArrayList<> ();
		initTimelineElement (romans, 16, english_channel, round1);
		initTimelineElement (belgae, 1, null, round1);
		ArrayList<BritTimelineElement> round3 = new ArrayList<> ();
		initTimelineElement (irish, 1, atlantic_ocean, round3);
		// TODO
	} // initTimeline

	private void initTimelineElement (BritNation nation, int numInvaders, BritArea area, ArrayList<BritTimelineElement> round1) {
		BritTimelineElement element = new BritTimelineElement (nation, area, numInvaders);
		round1.add (element);
	} // initTimelineElement

	private void initNations (BritGame game, BritPlayer yellow, BritPlayer blue, BritPlayer green, BritPlayer red) {
		romans = initNation (1, "romans", "Romans", BritColor.yellow, yellow, game);
		romano_british = initNation (2, "romano_british", "Romano-British", BritColor.yellow, yellow, game);
	    belgae = initNation (3, "belgae", "Belgae", BritColor.blue, blue, game);
	    welsh = initNation (4, "welsh", "Welsh", BritColor.green, green, game);
	    brigantes = initNation (5, "brigantes", "Brigantes", BritColor.red, red, game);
	    caledonians = initNation (6, "caledonians", "Caledonians", BritColor.green, green, game);
	    picts = initNation (7, "picts", "Picts", BritColor.blue, blue, game);
	    irish = initNation (8, "irish", "Irish", BritColor.red, red, game);
	    scots = initNation (9, "scots", "Scots", BritColor.yellow, yellow, game);
	    norsemen = initNation (10, "norsemen", "Norsemen", BritColor.red, red, game);
	    dubliners = initNation (11, "dubliners", "Dubliners", BritColor.yellow, yellow, game);
	    danes = initNation (12, "danes", "Danes", BritColor.green, green, game);
	    norwegians = initNation (13, "norwegians", "Norwegians", BritColor.yellow, yellow, game);
	    saxons = initNation (14, "saxons", "Saxons", BritColor.red, red, game);
	    jutes = initNation (15, "jutes", "Jutes", BritColor.green, green, game);
	    angles = initNation (16, "angles", "Angles", BritColor.blue, blue, game);
	    normans = initNation (17, "normans", "Normans", BritColor.blue, blue, game);
	} // initNations
	
	private BritNation initNation (int sort, String id, String name, BritColor color, BritPlayer controller, BritGame game) {
		BritNation nation = new BritNation (sort, id, name, color, controller);
		game.initNation (nation);
		return nation;
	} // initNation
	
	private void initUnits (BritGame game) {
		initInfantries (16, romans, "Infantry", game);
		initInfantries (24, romans, "Fort", game);
		initInfantries (8, romano_british, "Infantry", game);
		initInfantries (2, romano_british, "Cavalry", game);
	    initInfantries (10, belgae, "Infantry", game);
	    initInfantries (13, welsh, "Infantry", game);
	    initInfantries (11, brigantes, "Infantry", game);
	    initInfantries (7, caledonians, "Infantry", game);
	    initInfantries (10, picts, "Infantry", game);
	    initInfantries (8, irish, "Infantry", game);
	    initInfantries (11, scots, "Infantry", game);
	    initInfantries (10, norsemen, "Infantry", game);
	    initInfantries (9, dubliners, "Infantry", game);
	    initInfantries (18, danes, "Infantry", game);
	    initInfantries (12, norwegians, "Infantry", game);
	    initInfantries (20, saxons, "Infantry", game);
	    initInfantries (8, saxons, "Fort", game);
	    initInfantries (6, jutes, "Infantry", game);
	    initInfantries (17, angles, "Infantry", game);
	    initInfantries (8, normans, "Infantry", game);
	    initInfantries (4, normans, "Cavalry", game);
	} // initUnits
	
	private void initInfantries (int num, BritNation nation, String tmp, BritGame game) {
		for (int i = 0; i < num; i++) {
			BritUnit unit = new BritInfantry (nation);
			nation.initReinforcement (unit);
			nation.initUnit (unit);
			game.initUnit (unit);
		} // for
	} // initUnits
	
	private void initAreas (BritGame game) {
		HashMap<String, String> svgDById = getSvgDMap ();
		avalon = initArea (BritArea.AVALON, "Avalon", BritAreaType.NORMAL_LAND, game, svgDById);
		downlands = initArea (BritArea.DOWNLANDS, "Downlands", BritAreaType.DIFFICUL_LAND, game, svgDById);
		wessex = initArea (BritArea.WESSEX, "Wessex", BritAreaType.NORMAL_LAND, game, svgDById);
		sussex = initArea (BritArea.SUSSEX, "Sussex", BritAreaType.NORMAL_LAND, game, svgDById);
		kent = initArea (BritArea.KENT, "Kent", BritAreaType.NORMAL_LAND, game, svgDById);
		essex = initArea (BritArea.ESSEX, "Essex", BritAreaType.NORMAL_LAND, game, svgDById);
		lindsey = initArea (BritArea.LINDSEY, "Lindsey", BritAreaType.DIFFICUL_LAND, game, svgDById);
		suffolk = initArea (BritArea.SUFFOLK, "Suffolk", BritAreaType.NORMAL_LAND, game, svgDById);
		norfolk = initArea (BritArea.NORFOLK, "Norfolk", BritAreaType.NORMAL_LAND, game, svgDById);
		south_mercia = initArea (BritArea.SOUTH_MERCIA, "South Mercia", BritAreaType.NORMAL_LAND, game, svgDById);
		north_mercia = initArea (BritArea.NORTH_MERCIA, "North Mercia", BritAreaType.NORMAL_LAND, game, svgDById);
		hwicce = initArea (BritArea.HWICCE, "Hwicce", BritAreaType.NORMAL_LAND, game, svgDById);
		devon = initArea (BritArea.DEVON, "Devon ", BritAreaType.DIFFICUL_LAND, game, svgDById);
		cornwall = initArea (BritArea.CORNWALL, "Cornwall", BritAreaType.DIFFICUL_LAND, game, svgDById);
		gwent = initArea (BritArea.GWENT, "Gwent", BritAreaType.DIFFICUL_LAND, game, svgDById);
		dyfed = initArea (BritArea.DYFED, "Dyfed", BritAreaType.NORMAL_LAND, game, svgDById);
		powys = initArea (BritArea.POWYS, "Powys", BritAreaType.DIFFICUL_LAND, game, svgDById);
		gwynedd = initArea (BritArea.GWYNEDD, "Gwynedd", BritAreaType.NORMAL_LAND, game, svgDById);
		clwyd = initArea (BritArea.CLWYD, "Clwyd", BritAreaType.DIFFICUL_LAND, game, svgDById);
		march = initArea (BritArea.MARCH, "March", BritAreaType.NORMAL_LAND, game, svgDById);
		cheshire = initArea (BritArea.CHESHIRE, "Cheshire", BritAreaType.NORMAL_LAND, game, svgDById);
		york = initArea (BritArea.YORK, "York", BritAreaType.NORMAL_LAND, game, svgDById);
		bernicia = initArea (BritArea.BERNICIA, "Bernicia", BritAreaType.NORMAL_LAND, game, svgDById);
		pennines = initArea (BritArea.PENNINES, "Pennines", BritAreaType.DIFFICUL_LAND, game, svgDById);
		cumbria = initArea (BritArea.CUMBRIA, "Cumbria", BritAreaType.NORMAL_LAND, game, svgDById);
		lothian = initArea (BritArea.LOTHIAN, "Lothian", BritAreaType.NORMAL_LAND, game, svgDById);
		galloway = initArea (BritArea.GALLOWAY, "Galloway", BritAreaType.DIFFICUL_LAND, game, svgDById);
		dunedin = initArea (BritArea.DUNEDIN, "Dunedin", BritAreaType.NORMAL_LAND, game, svgDById);
		strathclyde = initArea (BritArea.STRATHCLYDE, "Strathclyde", BritAreaType.NORMAL_LAND, game, svgDById);
		dalriada = initArea (BritArea.DALRIADA, "Dalriada", BritAreaType.DIFFICUL_LAND, game, svgDById);
		alban = initArea (BritArea.ALBAN, "Alban", BritAreaType.DIFFICUL_LAND, game, svgDById);
		mar = initArea (BritArea.MAR, "Mar", BritAreaType.DIFFICUL_LAND, game, svgDById);
		moray = initArea (BritArea.MORAY, "Moray", BritAreaType.DIFFICUL_LAND, game, svgDById);
		skye = initArea (BritArea.SKYE, "Skye", BritAreaType.DIFFICUL_LAND, game, svgDById);
		caithness = initArea (BritArea.CAITHNESS, "Caithness", BritAreaType.DIFFICUL_LAND, game, svgDById);
		orkneys = initArea (BritArea.ORKNEYS, "Orkneys", BritAreaType.DIFFICUL_LAND, game, svgDById);
		hebrides = initArea (BritArea.HEBRIDES, "Hebrides", BritAreaType.DIFFICUL_LAND, game, svgDById);
		icelandic_sea = initArea (BritArea.ICELANDIC_SEA, "Icelandic Sea", BritAreaType.SEA, game, svgDById);
		north_sea = initArea (BritArea.NORTH_SEA, "North Sea", BritAreaType.SEA, game, svgDById);
		frisian_sea = initArea (BritArea.FRISIAN_SEA, "Frisian Sea", BritAreaType.SEA, game, svgDById);
		english_channel = initArea (BritArea.ENGLISH_CHANNEL, "English Channel", BritAreaType.SEA, game, svgDById);
		irish_sea = initArea (BritArea.IRISH_SEA, "Irish Sea", BritAreaType.SEA, game, svgDById);
		atlantic_ocean = initArea (BritArea.ATLANTIC_OCEAN, "Atlantic Ocean", BritAreaType.SEA, game, svgDById);
	} // initAreas
	
	private BritArea initArea (String id, String name, BritAreaType areaType, BritGame game, HashMap<String, String> svgDById) {
		String svgD = svgDById.get (id);
		BritArea area = null;
		switch (areaType) {
			case DIFFICUL_LAND: area = new BritLandArea (id, name, true, svgD); break;
			case NORMAL_LAND: area = new BritLandArea (id, name, false, svgD); break;
			case SEA: area = new BritSeaArea (id, name, svgD); break;
		} // switch
		game.initArea (area);
		return area;
	} // initArea
	
	private void initBorders () {
		initBorder (avalon, new BritArea[] { atlantic_ocean, devon, wessex, downlands, hwicce });
		initBorder (downlands, new BritArea[] { avalon, wessex, sussex, essex, south_mercia, hwicce });
		initBorder (wessex, new BritArea[] { avalon, devon, english_channel, sussex, downlands });
		initBorder (sussex, new BritArea[] { wessex, english_channel, kent, essex, downlands });
		initBorder (kent, new BritArea[] { sussex, english_channel, frisian_sea, essex });
		initBorder (essex, new BritArea[] { downlands, sussex, kent, frisian_sea, suffolk, south_mercia });
		initBorder (lindsey, new BritArea[] { suffolk, norfolk, frisian_sea, york, north_mercia });
		initBorder (suffolk, new BritArea[] { essex, frisian_sea, norfolk, lindsey, north_mercia, south_mercia });
		initBorder (norfolk, new BritArea[] { lindsey, york, march, hwicce, south_mercia, suffolk });
		initBorder (south_mercia, new BritArea[] { downlands, essex, suffolk, north_mercia, hwicce });
		initBorder (hwicce, new BritArea[] { march, powys, gwent, atlantic_ocean, avalon, downlands, south_mercia, north_mercia });
		initBorder (north_mercia, new BritArea[] { south_mercia, suffolk, lindsey, york, march, hwicce });
		initBorder (march, new BritArea[] { clwyd, powys, hwicce, north_mercia, york, cheshire });
		initBorder (cheshire, new BritArea[] { irish_sea, atlantic_ocean, clwyd, march, york, pennines, cumbria });
		initBorder (york, new BritArea[] { pennines, cheshire, march, north_mercia, lindsey, frisian_sea, north_sea, bernicia });
		initBorder (bernicia, new BritArea[] { pennines, york, north_sea, lothian });
		initBorder (pennines, new BritArea[] { lothian, cumbria, cheshire, york, bernicia });
		initBorder (cumbria, new BritArea[] { galloway, irish_sea, cheshire, pennines, lothian });
		initBorder (lothian, new BritArea[] { dunedin, strathclyde, galloway, cumbria, pennines, bernicia, north_sea });
		initBorder (galloway, new BritArea[] { strathclyde, irish_sea, cumbria, lothian });
		
		initBorder (devon, new BritArea[] { atlantic_ocean, cornwall, english_channel, wessex, avalon });
		initBorder (cornwall, new BritArea[] { atlantic_ocean, english_channel, devon });
		initBorder (gwent, new BritArea[] { atlantic_ocean, hwicce, powys, dyfed });
		initBorder (dyfed, new BritArea[] { atlantic_ocean, gwent, powys });
		initBorder (powys, new BritArea[] { clwyd, gwynedd, atlantic_ocean, dyfed, gwent, hwicce, march });
		initBorder (gwynedd, new BritArea[] { atlantic_ocean, powys, clwyd });
		initBorder (clwyd, new BritArea[] { atlantic_ocean, gwynedd, powys, march, cheshire });

		initBorder (dunedin, new BritArea[] { alban, dalriada, strathclyde, lothian, north_sea, mar });
		initBorder (strathclyde, new BritArea[] { dalriada, irish_sea, galloway, lothian, dunedin });
		initBorder (dalriada, new BritArea[] { skye, irish_sea, strathclyde, dunedin, alban });
		initBorder (alban, new BritArea[] { moray, skye, dalriada, dunedin, mar });
		initBorder (mar, new BritArea[] { icelandic_sea, moray, alban, dunedin, north_sea });
		initBorder (moray, new BritArea[] { caithness, skye, alban, mar, icelandic_sea });
		initBorder (skye, new BritArea[] { caithness, icelandic_sea, irish_sea, dalriada, alban, moray });
		initBorder (hebrides, new BritArea[] { icelandic_sea });
		initBorder (caithness, new BritArea[] { icelandic_sea, skye, moray });
		initBorder (orkneys, new BritArea[] { icelandic_sea });
		
	    initBorder (atlantic_ocean, new BritArea[] { english_channel, cornwall, devon, avalon, hwicce, gwent, dyfed, powys, gwynedd, clwyd, cheshire, irish_sea });
	    initBorder (english_channel, new BritArea[] { atlantic_ocean, cornwall, devon, wessex, sussex, kent, frisian_sea });
	    initBorder (frisian_sea, new BritArea[] { english_channel, kent, essex, suffolk, norfolk, lindsey, york, north_sea });
	    initBorder (north_sea, new BritArea[] { frisian_sea, york, bernicia, lothian, dunedin, mar, icelandic_sea });
	    initBorder (icelandic_sea, new BritArea[] { north_sea, mar, moray, caithness, skye, irish_sea, hebrides, orkneys });
	    initBorder (irish_sea, new BritArea[] { icelandic_sea, skye, dalriada, strathclyde, galloway, cumbria, cheshire, atlantic_ocean });
	    
	}
	
	private void initBorder (BritArea area, BritArea[] otherAreas) {
		for (BritArea otherArea : otherAreas) {
			BritBorder border = new BritBorder (otherArea, BritBorderType.NORMAL_BORDER);
			area.initBorder (border);
		} // for
	} // initBorder
	
	private HashMap<String, String> getSvgDMap () {
		HashMap<String, String> attrDById = new HashMap<String, String> ();
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream ("/britannia-map.svg");
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance ();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder ();
	        Document doc = dBuilder.parse (is);
	        doc.getDocumentElement ().normalize ();
	        NodeList nPaths = doc.getElementsByTagName ("path");
	        for (int i = 0; i < nPaths.getLength(); i++) {
	            Node nPath = nPaths.item (i);
	            Element ePath = (Element) nPath;
	            String id = ePath.getAttribute ("id");
	            String d = ePath.getAttribute ("d");
	            attrDById.put (id, d);
	        } // for
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } // try - catch
		return attrDById;
	} // getAttrDMap
	
} // GameSetup
