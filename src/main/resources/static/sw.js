if(!self.define){let s,e={};const l=(l,i)=>(l=new URL(l+".js",i).href,e[l]||new Promise((e=>{if("document"in self){const s=document.createElement("script");s.src=l,s.onload=e,document.head.appendChild(s)}else s=l,importScripts(l),e()})).then((()=>{let s=e[l];if(!s)throw new Error(`Module ${l} didn’t register its module`);return s})));self.define=(i,r)=>{const n=s||("document"in self?document.currentScript.src:"")||location.href;if(e[n])return;let a={};const t=s=>l(s,n),u={module:{uri:n},exports:a,require:t};e[n]=Promise.all(i.map((s=>u[s]||t(s)))).then((s=>(r(...s),a)))}}define(["./workbox-fa446783"],(function(s){"use strict";self.skipWaiting(),s.clientsClaim(),s.precacheAndRoute([{url:"assets/Add-b423c505.js",revision:null},{url:"assets/api-142e8b1c.js",revision:null},{url:"assets/context-48e04b95.js",revision:null},{url:"assets/Download-08d401c1.css",revision:null},{url:"assets/Download-22d64266.js",revision:null},{url:"assets/Form-e83bc1d6.js",revision:null},{url:"assets/Home-f4365923.js",revision:null},{url:"assets/index-2d7ac089.js",revision:null},{url:"assets/index-71d789b0.css",revision:null},{url:"assets/Input-7e965a27.js",revision:null},{url:"assets/Login-cc684101.css",revision:null},{url:"assets/Login-d1b4ff71.js",revision:null},{url:"assets/ParserPlaylist-3587ab47.js",revision:null},{url:"assets/ParserPlaylist-c7497bf3.css",revision:null},{url:"assets/Parsertext-2c56521c.css",revision:null},{url:"assets/Parsertext-a94e1f1a.js",revision:null},{url:"assets/Search-a2afe438.css",revision:null},{url:"assets/Search-c665f54e.js",revision:null},{url:"assets/Set-6070a120.js",revision:null},{url:"assets/Space-e1bbbf48.js",revision:null},{url:"assets/Switch-57ee3419.js",revision:null},{url:"assets/Thing-661dac6c.js",revision:null},{url:"assets/Tooltip-afa8d11a.js",revision:null},{url:"assets/TopWitge-7c110398.js",revision:null},{url:"assets/use-merged-state-b12a1513.js",revision:null},{url:"index.html",revision:"2df7a23f91dd7a7d23916d9115b5b294"},{url:"pwa/logo.png",revision:"a4002c8e6971fa121256144d5ad2bf98"},{url:"registerSW.js",revision:"1872c500de691dce40960bb85481de07"},{url:"vite.svg",revision:"8e3a10e157f75ada21ab742c022d5430"},{url:"./pwa/logo.png",revision:"a4002c8e6971fa121256144d5ad2bf98"},{url:"manifest.webmanifest",revision:"caf34c20a8566ecc834db127daac74ae"}],{}),s.cleanupOutdatedCaches(),s.registerRoute(new s.NavigationRoute(s.createHandlerBoundToURL("index.html")))}));
