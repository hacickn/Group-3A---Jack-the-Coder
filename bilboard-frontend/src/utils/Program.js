class Program {
    static clubMap = new Map()
    static program = {}
    static currentEvent = {}

    static getClubMap() {
        return this.clubMap
    }

    static getProgram() {
        return this.program
    }

    static getCurrentEvent() {
        return this.currentEvent
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
    },
    getProgram() {
        return Program.program
    },
    setProgram( program ) {
        Program.program = program
    },
    getCurrentEvent() {
        return Program.currentEvent
    },
    setCurrentEvent( currentEvent ) {
        Program.currentEvent = currentEvent
    }
}