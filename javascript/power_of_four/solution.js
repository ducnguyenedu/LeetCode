/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfFour = function(n) {
    if (n <= 0) return false;
        if (n === 1) return true;

        function lsb(num) {
            let p = 1;
            while (num > 0) {
                if (num & 1 > 0) return p - 1;
                p++;
                num >>= 1;
            }
            return -1;
        }

        return lsb(n) % 2 === 0 && (n & (n - 1)) === 0;

};