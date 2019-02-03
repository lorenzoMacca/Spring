//	import Feature from '.top/ol/Feature.js';
//	import Map from 'ol/Map.js';
//	import View from 'ol/View.js';
//	import Point from 'ol/geom/Point.js';
//	import {Tile as TileLayer, Vector as VectorLayer} from 'ol/layer.js';
//	import {fromLonLat} from 'ol/proj.js';
//	import TileJSON from 'ol/source/TileJSON.js';
//	import VectorSource from 'ol/source/Vector.js';
//	import {Icon, Style} from 'ol/style.js';
//
//
//
//
//	var rome = new Feature({
//		geometry: new Point(fromLonLat([7.6379748, 51.900642]))
//	});
//	rome.setStyle(new Style({
//		image: new Icon(/** @type {module:ol/style/Icon~Options} */ ({
//			color: '#8959A8',
//			crossOrigin: 'anonymous',
//			src: 'data/dot.png'
//		}))
//	}));
//	var vectorSource = new VectorSource({
//		features: [rome]
//	});
//
//	var vectorLayer = new VectorLayer({
//		source: vectorSource
//	});
//
//
//
//
//	function getMap(){
//		return new ol.Map({
//			target: 'map',
//			layers: [
//				new ol.layer.Tile({
//					source: new ol.source.OSM()
//				}), vectorLayer
//				],
//				view: new ol.View({
//					center: ol.proj.fromLonLat([7.6379748, 51.900642]),
//					zoom: 16
//				})
//		});
//	}