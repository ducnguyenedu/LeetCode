/**
 * @param {number[]} arr
 * @return {number}
 */
function findSpecialInteger(arr) {
    let counts = new Array(100001).fill(0);
    for (let i = 0; i < arr.length; ++i) {
        counts[arr[i]]++;
    }
    let target = arr.length / 4;
    for (let i = 0; i < 100001; ++i) {
        if (counts[i] > target) {
            return i;
        }
    }
    
    return -1;
}

