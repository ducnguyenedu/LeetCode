/**
 * @param {number} n
 * @param {number[]} leftChild
 * @param {number[]} rightChild
 * @return {boolean}
 */
var validateBinaryTreeNodes = function(n, leftChild, rightChild) {
    const p = Array.from({length: n}, (v, i) => i)
    let components = n

    const find = (node) => {
        if(p[node] !== node) p[node] = find(p[node])
        return p[node]
    }

    const union = (parent, child) => {
        let parentP = find(parent), childPar = find(child)

        if(childPar !== child || parentP === childPar) return false

        components--
        p[childPar] = parentP
        return true
    }

    for(let node=0; node<n; node++){
        for(let child of [leftChild[node], rightChild[node]]){
            if(child === -1) continue
            if(!union(node, child)) return false

        }
    }

    return components === 1
};