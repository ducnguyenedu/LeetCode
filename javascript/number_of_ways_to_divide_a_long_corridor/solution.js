/**
 * @param {string} corridor
 * @return {number}
 */
var numberOfWays = function(corridor) {
    const MOD = 1e9+7;
    let inPlants = false, seats = 0, seatEnd = -1, sections = 1;
    for(let i=0; i<corridor.length; i++)
    {
        if(inPlants)
        {
            if(corridor[i] === 'S')
            {
                sections = (sections * (i-seatEnd)) % MOD;
                inPlants = false;
                seats = 1;
            }
        }
        else
        {
            if(corridor[i] === 'S')
            {
                seats++;
                if(seats === 2)
                {
                    inPlants = true;
                    seatEnd = i;
                }
            }
        }
    }
    if(seatEnd === -1)
        return 0;

    if(!inPlants && seats === 1)
        return 0;

    return sections;
};