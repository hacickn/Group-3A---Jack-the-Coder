class Program {
    static clubMap = new Map()

    static getClubMap() {
        return this.clubMap
    }
}

export default {
    getClubMap() {
        return Program.clubMap
    },
    addClub( club, id ) {
        Program.clubMap.set( id, club )
    },
    getClub( id ) {
        return Program.clubMap.get( id )
    }
}