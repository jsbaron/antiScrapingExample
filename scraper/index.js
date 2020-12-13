const $ = require("cheerio");

const puppeteer = require("puppeteer");

const WEB_PAGE_URL = "http://cs6760-client.s3-website-us-east-1.amazonaws.com/";

const cumulativeData = []
let data = [];

const NAMES = "button";
const TWEET = ".card-body";
const LOCATION = ".ml-auto";
const PAGINATION = ".pagination"

class Scraper {

    getNextPageIdentifier(numChildren)  {
        return ".page-item:nth-child(" + (numChildren - 1).toString() + ") span"
    }

    async addNames(page) {
        $(NAMES, await page.content()).each((i, el) => {
            data.push({
                user: $(el).text()
            });
        });
    }

    async addTweet(page) {
        $(TWEET, await page.content()).each((i, el) => {
            data[i].tweet = $(el).text()
        })
    }

    async addLocation(page) {
        $(LOCATION, await page.content()).each((i, el) => {
            data[i].location = $(el).text()
        })
    }

    async clickNextPageButton(page) {
        const numChildren = $(PAGINATION, await page.content())
            .children().length

        await (await page.$(this.getNextPageIdentifier(numChildren))).click();
    }

    async close(browser) {
        await browser.close();
    }

    async go() {
        const browser = await puppeteer.launch();
        const page = await browser.newPage();
        page.on('response', response => {
            console.log("response code: ", response.status());
        });
        await page.goto(WEB_PAGE_URL);
        for (let i=0; i<10; i++) {
            await page.waitForTimeout(2000);
            try {
                await this.addNames(page);
                await this.addTweet(page);
                await this.addLocation(page);
                cumulativeData.push(data);
                await this.clickNextPageButton(page);
            } catch(e) {
                console.log(e)
            }
            data = [];
        }
        console.log(cumulativeData)
        console.log("Scraped " + cumulativeData.length + " page(s).")
        await this.close(browser);
    }
}

const scraper = new Scraper();
scraper.go();