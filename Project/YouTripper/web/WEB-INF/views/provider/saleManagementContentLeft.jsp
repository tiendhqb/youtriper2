<div>
    <div class="tab-sales">
        <div class="removeArrow3">
            <select class="selectSalePack" name="currentPackage" id="currentPackage" ng-model="currentPackage" convert-to-number>
                <option value="0" selected>All packages</option>
                <option ng-repeat="option in packages" value="{{option.packageID}}">{{option.packageName}}</option>
            </select>
        </div>
        <span style="color: white">From</span><br>
        <input class="round normalFont saleDate" placeholder="Start Date" type="text" id="from" name="from" required><br>
        <span style="color: white">To</span><br>
        <input class="round normalFont saleDate" placeholder="End Date" type="text" id="to" name="to" required>                            
        <br><br>
    </div>
</div>