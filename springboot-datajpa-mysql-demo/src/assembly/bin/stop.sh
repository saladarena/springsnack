PIDFILE="./start$1.pid"
echo $PIDFILE
if [ ! -f "$PIDFILE" ]
then
    echo "No App to stop (could not find file $PIDFILE)"
else
    kill $(cat "$PIDFILE")
    rm -f "$PIDFILE"
    echo STOPPED
fi
exit 0
