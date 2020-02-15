/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var boys = ["Peter", "lars", "Ole"];
var girls = ["Janne", "sanne", "Hanne"];
var all = boys.concat(girls);
const allConcHyphen = all.join(',');
const allConcComma = all.join('-');
all.push('Lone', 'Gitte');
all.unshift('Hans', 'Kurt');
all.shift();
all.pop();
all.splice(3, 2);
all.reverse();
all.sort();

function titleCase(text) {
   text.charAt(0).toUpperCase();
   return text;
}


const map = all.map(titleCase);
console.log(all);